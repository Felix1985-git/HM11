package academy.belhard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressConnector {

    private static final String INSERT = "INSERT INTO addresses (city, street, homeNumber, homeBlock, apartment) VALUES(?, ?, ?, ?, ?)";
    private static final String SELECT_BY_ALL = "SELECT * FROM addresses";
    private static final String DELETE_BY_ID = "DELETE FROM addresses WHERE id = ?";
    private static final String UPDATE_BY_ID = "UPDATE addresses SET city = ?, street = ?, homeNumber = ?, homeBlock = ?, apartment = ? WHERE id = ?";

    // Метод для записи объекта в таблицу addresses БД homeWork11_db
    public static void add(Address address) {
        Connection connection = ConnectorToDb.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(INSERT)
        ) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHomeNumber());
            statement.setString(4, address.getHomeBlock());
            statement.setString(5, address.getApartment());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод для чтения всей таблицы addresses из БД homeWork11_db
    public static List<Address> readAll() {
        Connection connection = ConnectorToDb.getConnection();
        List<Address> addressList = new ArrayList<>();
        try (
                PreparedStatement statement = connection.prepareStatement(SELECT_BY_ALL)
        ) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = AddressBuilder.buildAddress(resultSet);
                addressList.add(address);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return addressList;
    }

    // Метод для удаления строки из таблицы addresses БД homeWork11_db
    public static void delete(int id) {
        Connection connection = ConnectorToDb.getConnection();
        try (
                PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID)
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Метод изменения строки таблицы addresses БД homeWork11_db
    public static void update(Address address, int id) {
        Connection connection = ConnectorToDb.getConnection();

        try (
                PreparedStatement statement = connection.prepareStatement(UPDATE_BY_ID)
        ) {
            statement.setString(1, address.getCity());
            statement.setString(2, address.getStreet());
            statement.setInt(3, address.getHomeNumber());
            statement.setString(4, address.getHomeBlock());
            statement.setString(5, address.getApartment());
            statement.setInt(6, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
