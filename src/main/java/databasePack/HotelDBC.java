package databasePack;

import hotelPack.Hotel;
import exceptionsPack.HotelException;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Properties;

import static queries.Queries.INSERT_HOTEL_QUERY;

@Component
public class HotelDBC {
    private final Connection connection;
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bookingapp";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "letmein";

    public HotelDBC() throws HotelException {
        Properties properties = new Properties();
        properties.put("user", DB_USER);
        properties.put("password", DB_PASSWORD);
        try {
            connection = DriverManager.getConnection(DB_URL, properties);
        } catch (SQLException e) {
            throw new HotelException(e.getMessage());
        }
    }

    public void insert(Hotel hotel) throws HotelException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_HOTEL_QUERY)) {
            preparedStatement.setString(1, hotel.getName());
            preparedStatement.setString(2, hotel.getAddress());
            preparedStatement.setString(3, hotel.getCity());
            preparedStatement.setString(4, hotel.getState());
            preparedStatement.setString(5, hotel.getPhone());
            preparedStatement.setString(6, hotel.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new HotelException("Database could not be accessed: " + e.getMessage());
        }
    }
}
