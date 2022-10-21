package hu.petrik.ingatlanoop;

public class Ingatlan {
    private String street;
    private String city;
    private String zip;
    private String state;
    private int beds;
    private int baths;
    private int sq__ft;
    private String type;
    private String sale_date;
    private int price;
    private double latitude;
    private double longitude;

    public Ingatlan(String sor) {
        String[] adatok = sor.split(",");
        this.street = adatok[0];
        this.city = adatok[1];
        this.zip = adatok[2];
        this.state = adatok[3];
        this.beds = Integer.parseInt(adatok[4]);
        this.baths = Integer.parseInt(adatok[5]);
        this.sq__ft = Integer.parseInt(adatok[6]);
        this.type = adatok[7];
        this.sale_date = adatok[8];
        this.price = Integer.parseInt(adatok[9]);
        this.latitude = Double.parseDouble(adatok[10]);
        this.longitude = Double.parseDouble(adatok[11]);
    }

    public Ingatlan(String street, String city, String zip, String state, int beds, int baths, int sq__ft, String type, String sale_date, int price, double latitude, double longitude) {
        this.street = street;
        this.city = city;
        this.zip = zip;
        this.state = state;
        this.beds = beds;
        this.baths = baths;
        this.sq__ft = sq__ft;
        this.type = type;
        this.sale_date = sale_date;
        this.price = price;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public int getBeds() {
        return beds;
    }

    public int getBaths() {
        return baths;
    }

    public int getSq__ft() {
        return sq__ft;
    }

    public String getType() {
        return type;
    }

    public String getSale_date() {
        return sale_date;
    }

    public int getPrice() {
        return price;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return "Ingatlan{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", state='" + state + '\'' +
                ", beds=" + beds +
                ", baths=" + baths +
                ", sq__ft=" + sq__ft +
                ", type='" + type + '\'' +
                ", sale_date='" + sale_date + '\'' +
                ", price=" + price +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
