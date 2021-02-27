package academy.belhard;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressBuilder {

    public static Address buildAddress(ResultSet resultSet) {
        Address result = null;

        try {
            int id = resultSet.getInt("id");
            String city = resultSet.getString("city");
            String street = resultSet.getString("street");
            int homeNumber = resultSet.getInt("homeNumber");
            String homeBlock = resultSet.getString("homeBlock");
            String apartment = resultSet.getString("apartment");
            result = new Address(id, city, street, homeNumber, homeBlock, apartment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
