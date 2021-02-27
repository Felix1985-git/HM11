package academy.belhard;

// Создаем класс Address в соответствии со структурой таблицы addresses БД homeWork11_db
public class Address {
    private int id;
    private String city;
    private String street;
    private int homeNumber;
    private String homeBlock;
    private String apartment;

    public Address(int id, String city, String street, int homeNumber, String homeBlock, String apartment) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.homeBlock = homeBlock;
        this.apartment = apartment;
    }

    public int getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(int homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getHomeBlock() {
        return homeBlock;
    }

    public void setHomeBlock(String homeBlock) {
        this.homeBlock = homeBlock;
    }

    public String getApartment() {
        return apartment;
    }

    public void setApartment(String apartment) {
        this.apartment = apartment;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", city: " + city +
                ", street: " + street +
                ", homeNumber: "+ homeNumber + '/' +
                homeBlock  +
                ", apartment: " + apartment +
                "\n";
    }

    public static Address addressToSave(String city, String street, int homeNumber, String homeBlock, String apartment) {
        return new Address(-1, city, street, homeNumber, homeBlock, apartment);
    }
}
