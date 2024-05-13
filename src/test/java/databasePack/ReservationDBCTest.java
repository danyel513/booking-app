package databasePack;

import exceptionsPack.HotelException;
import hotelPack.Room;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import reservationPack.Reservation;

import java.sql.*;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class ReservationDBCTest
{
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/bookingapp";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "letmein";

    private static ReservationDBC reservationDBC;

    @BeforeAll
    public static void setUp() throws HotelException
    {
        reservationDBC = new ReservationDBC();
    }

    @AfterAll
    public static void tearDown() throws SQLException
    {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement())
        {
            String deleteQuery = "DELETE FROM reservations WHERE clientName = 'Test Reservation'";
            statement.executeUpdate(deleteQuery);
        }
    }

    @Test
    public void testInsert() throws HotelException
    {
        Room r = new Room(0, 0, 0);
        r.setRoomId(2);
        Reservation testReservation = new Reservation("Test Reservation", new Date(), new Date(), r);


        assertDoesNotThrow(() -> reservationDBC.insert(testReservation), "Insert should not throw an exception.");

        try {
            Reservation retrievedReservation = retrieveTestReservation();
            assertNotNull(retrievedReservation, "Reservation should have been inserted into the database.");
            assertEquals(testReservation.getClientName(), retrievedReservation.getClientName(), "Inserted reservation name should match.");
            //assertEquals(testReservation.getDateCheckIn(), retrievedReservation.getDateCheckIn(), "Inserted reservation check in date should match.");
            //assertEquals(testReservation.getDateCheckOut(), retrievedReservation.getDateCheckOut(), "Inserted reservation check out date should match.");
            }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private Reservation retrieveTestReservation() throws SQLException
    {
        Reservation reservation = null;
        String query = "SELECT * FROM reservations WHERE clientName = 'Test Reservation'";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {
            if (resultSet.next())
            {
               String clientName = resultSet.getString("clientName");
               Date dateCheckIn = resultSet.getTimestamp("checkInDate");
               Date dateCheckOut = resultSet.getTimestamp("checkOutDate");
               reservation = new Reservation(clientName, dateCheckIn, dateCheckOut, new Room(0, 0, 0));
            }
        }
        return reservation;
    }
}

