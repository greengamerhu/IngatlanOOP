package hu.petrik.ingatlanoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    private static List<Ingatlan> ingatlanok;
    public static void main(String[] args) {
        String fajlNev = "realestatetransactions.csv";
        try {
            beolvas(fajlNev);
            //ingatlanok.forEach(System.out::println);
            System.out.printf("Az állományban %d eladás került feljegyzésre\n",
                    ingatlanok.stream().count());
            System.out.printf("A legnagyobb alapterületű ingatlan:\n\t%s\n",
                    ingatlanok.stream().max(Comparator.comparingInt(Ingatlan::getSq__ft)));
            System.out.printf("Az összesített ingatlan eladások értéke %d $\n",
                    ingatlanok.stream().mapToInt(Ingatlan::getPrice).sum());
            System.out.printf("%d ingatlan méretét nem határozták meg\n",
                    ingatlanok.stream().filter(ingatlan -> ingatlan.getSq__ft() == 0).count());
            String varos = "WEST SACRAMENTO";
            System.out.printf("%s %s a listában\n", varos,
                ingatlanok.stream().anyMatch(ingatlan -> ingatlan.getCity().equals(varos))
                    ? "szerepel" : "nem szerepel");
            System.out.printf("%s eladások száma: %d\n", varos,
                ingatlanok.stream().filter(ingatlan -> ingatlan.getCity().equals(varos)).count());
            System.out.printf("%s eladások összértéke: %d $\n", varos,
                ingatlanok.stream().filter(ingatlan -> ingatlan.getCity().equals(varos))
                        .mapToInt(Ingatlan::getPrice).sum());
            System.out.printf("%s ingatlan eladásai: %s\n", varos,
                ingatlanok.stream().filter(ingatlan -> ingatlan.getCity().equals(varos))
                        .collect(Collectors.toList()));
            Map<String, Long> varosok = ingatlanok.stream()
                    .collect(Collectors.groupingBy(Ingatlan::getCity, Collectors.counting()));
            for (Map.Entry<String, Long> entry: varosok.entrySet()) {
                System.out.printf("%s - %d\n", entry.getKey(), entry.getValue());
            }
        } catch (IOException e) {
            System.out.printf("Hiba történt a(z) %s fájl beolvasása során", fajlNev);
        }
    }

    private static void beolvas(String fajlNev) throws IOException {
        ingatlanok = new ArrayList<>();

        FileReader fr = new FileReader(fajlNev);
        BufferedReader br = new BufferedReader(fr);

        String fejlec = br.readLine();

        String sor = br.readLine();
        while (sor != null && !sor.isEmpty()){
            Ingatlan i = new Ingatlan(sor);
            ingatlanok.add(i);
            sor = br.readLine();
        }

        br.close();
        fr.close();
    }
}
