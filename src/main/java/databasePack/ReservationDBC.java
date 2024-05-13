package databasePack;

import exceptionsPack.HotelException;
import exceptionsPack.ReservationException;
import reservationPack.Reservation;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static queries.Queries.INSERT_RESERVATION_QUERY;

public class ReservationDBC
{
    private final Connection connection;

    public ReservationDBC() throws HotelException
    {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "letmein");
        try
        {
            final String url = "jdbc:mysql://127.0.0.1:3306/bookingapp";
            connection = DriverManager.getConnection(url, properties);
        }
        catch (SQLException e)
        {
            throw new HotelException("Database connection error: " + e.getMessage());
        }
    }

    public void insert(Reservation reservation) throws ReservationException
    {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RESERVATION_QUERY)) {
            preparedStatement.setString(1, reservation.getClientName());
            preparedStatement.setDate(2, new java.sql.Date(reservation.getDateCheckIn().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(reservation.getDateCheckOut().getTime()));
            preparedStatement.setInt(4, reservation.getRoom().getRoomId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new ReservationException("Failed to insert reservation: " + e.getMessage());
        }
    }
}
