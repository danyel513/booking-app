package databasePack;

import exceptionsPack.RoomException;
import hotelPack.Room;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;

public class RoomDBCTest
{
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bookingapp";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "letmein";

    private static RoomDBC roomDBC;

    @BeforeAll
    public static void setUp() throws RoomException
    {
        roomDBC = new RoomDBC();
    }

    @AfterAll
    public static void tearDown() throws SQLException
    {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement())
        {
            String deleteQuery = "DELETE FROM rooms WHERE roomnumber = 0 and capacity = 0 and price = 0";
            statement.executeUpdate(deleteQuery);
        }
    }

    @Test
    public void testInsert()
    {
        Room testRoom = new Room(0, 0, 0);

        assertDoesNotThrow(() -> roomDBC.insert(testRoom), "Insert should not throw an exception.");

        try {
            Room retrievedRoom = retrieveTestRoom();
            assertNotNull(retrievedRoom, "Room should have been inserted into the database.");
            assertEquals(testRoom.getRoomNumber(), retrievedRoom.getRoomNumber(), "Inserted room number should match.");
            assertEquals(testRoom.getCapacity(), retrievedRoom.getCapacity(), "Inserted room capacity should match.");
            assertEquals(testRoom.getPrice(), retrievedRoom.getPrice(), "Inserted room price should match.");
            }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private Room retrieveTestRoom() throws SQLException
    {
        Room room = null;
        String query = "SELECT * FROM rooms WHERE roomNumber = 0 and capacity = 0 and price = 0";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next())
            {
                int roomNumber = resultSet.getInt("roomNumber");
                int capacity = resultSet.getInt("capacity");
                int price = resultSet.getInt("price");
                room = new Room(roomNumber, capacity, price);
            }
        }
        return room;
    }
}


