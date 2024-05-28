package databasePack;

import exceptionsPack.HotelException;
import hotelPack.Hotel;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class HotelDBCTest {
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bookingapp";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "letmein";

    private static HotelDBC hotelDBC;

    @BeforeAll
    public static void setUp() throws HotelException
    {
        hotelDBC = new HotelDBC();
    }

    @AfterAll
    public static void tearDown() throws SQLException
    {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement())
        {
            String deleteQuery = "DELETE FROM hotels WHERE name = 'Test Hotel'";
            statement.executeUpdate(deleteQuery);
        }
    }

    @Test
    public void testInsert()
    {
        Hotel testHotel = new Hotel("Test Hotel", "Test Address", "Test City", "Test State", "1234567890", "test@example.com");

        assertDoesNotThrow(() -> hotelDBC.insert(testHotel), "Insert should not throw an exception.");

        try {
            Hotel retrievedHotel = retrieveTestHotel();
            assertNotNull(retrievedHotel, "Hotel should have been inserted into the database.");
            assertEquals(testHotel.getName(), retrievedHotel.getName(), "Inserted hotel name should match.");
            assertEquals(testHotel.getAddress(), retrievedHotel.getAddress(), "Inserted hotel address should match.");
            assertEquals(testHotel.getCity(), retrievedHotel.getCity(), "Inserted hotel city should match.");
            assertEquals(testHotel.getState(), retrievedHotel.getState(), "Inserted hotel state should match.");
            assertEquals(testHotel.getPhone(), retrievedHotel.getPhone(), "Inserted hotel phone should match.");
            assertEquals(testHotel.getEmail(), retrievedHotel.getEmail(), "Inserted hotel email should match.");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private Hotel retrieveTestHotel() throws SQLException
    {
        Hotel hotel = null;
        String query = "SELECT * FROM hotels WHERE name = 'Test Hotel'";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                hotel = new Hotel(name, address, city, state, phone, email);
            }
        }
        return hotel;
    }
}
