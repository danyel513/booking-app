package databasePack;

import exceptionsPack.UserException;
import hotelPack.Room;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reservationPack.Reservation;
import userPack.User;
import java.util.Date;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class UserDBCTest
{
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bookingapp";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "letmein";

    private static UserDBC userDBC;

    @BeforeAll
    public static void setUp() throws UserException
    {
        userDBC = new UserDBC();
    }

    @AfterAll
    public static void tearDown() throws SQLException
    {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement())
        {
            String deleteQuery = "DELETE FROM users WHERE name='Test User'";
            statement.executeUpdate(deleteQuery);
        }
    }

    @Test
    public void testInsert()
    {
        User testUser = new User("Test User", "test@gmail.com", "111", "pass");
        Room room = new Room(0, 0, 0);
        room.setRoomId(2);
        Reservation r = new Reservation("A", new Date(), new Date(), room);
        r.setId(11);
        testUser.setReservation(r);
        assertDoesNotThrow(() -> userDBC.insert(testUser), "Insert should not throw an exception.");

        try {
            User retrievedUser = retrieveTestUser();
            assertNotNull(retrievedUser, "User should have been inserted into the database.");
            assertEquals(testUser.getName(), retrievedUser.getName(), "Inserted user name should match.");
            assertEquals(testUser.getEmail(), retrievedUser.getEmail(), "Inserted user email should match.");
            assertEquals(testUser.getReservation(), retrievedUser.getReservation(), "Inserted user reservation should match.");
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private User retrieveTestUser() throws SQLException
    {
        User user = null;
        String query = "SELECT * FROM users WHERE name='Test User'";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next())
            {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phone = resultSet.getString("phoneNumber");
                String password = resultSet.getString("password");
                int id = resultSet.getInt("reservationId");
                Room room = new Room(0, 0, 0);
                room.setRoomId(2);
                Reservation r = new Reservation("A", new Date(), new Date(), room);
                r.setId(11);
                user = new User(name, email, phone, password);
                user.setReservation(r);
            }
        }
        return user;
    }
}
