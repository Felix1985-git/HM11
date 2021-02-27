package academy.belhard;

public class Main {

    public static void main(String[] args) {

        // Создаем 5 объектов типа Address
        Address address = Address.addressToSave("Minsk", "Holy", 78, "3", "26");
        Address address1 = Address.addressToSave("Tomsk", "Rainbows", 29, "5", "33");
        Address address2 = Address.addressToSave("Brest", "Flowers", 36, null, "28");
        Address address3 = Address.addressToSave("NewYork", "Heroes", 51, "6", null);
        Address address4 = Address.addressToSave("Paris", "KingsRoad", 40, "5", "9");

        // Сохраняам объекты класса Address в таблицу addresses БД homeWork11_db методом add класса AddressConnector
        AddressConnector.add(address);
        AddressConnector.add(address1);
        AddressConnector.add(address2);
        AddressConnector.add(address3);
        AddressConnector.add(address4);

        // Выводим результат в консоль (метод readAll класса AddressConnector)
        AddressConnector.readAll().forEach(System.out::print);
        System.out.println();

        // Изменяем адреса таблицы addresses БД homeWork11_db (метод update класса AddressConnector)
        AddressConnector.update(Address.addressToSave("London", "BakerStreet", 66, "2", "1"), 1);
        AddressConnector.update(Address.addressToSave("Houston", "Problem", 13, "6", "6"), 5);

        // Выводим результат в консоль (метод readAll класса AddressConnector)
        AddressConnector.readAll().forEach(System.out::print);
        System.out.println();

        // Удаляем адреса таблицы addresses БД homeWork11_db (метод delete класса AddressConnector)
        AddressConnector.delete(4);
        AddressConnector.delete(2);

        // Выводим результат в консоль (метод readAll класса AddressConnector)
        AddressConnector.readAll().forEach(System.out::print);
    }
}
