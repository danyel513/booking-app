package databasePack;

import exceptionsPack.HotelException;
import exceptionsPack.RoomException;
import hotelPack.Room;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static queries.Queries.INSERT_ROOM_QUERY;

public class RoomDBC
{
    private final Connection connection;

    public RoomDBC() throws RoomException
    {
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "letmein");
        try {
            final String url = "jdbc:mysql://127.0.0.1:3306/bookingapp";
            connection = DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new RoomException("Database connection error: " + e.getMessage());
        }
    }

    public void insert(Room room) throws HotelException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ROOM_QUERY)) {
            preparedStatement.setInt(1, room.getRoomNumber());
            preparedStatement.setInt(2, room.getCapacity());
            preparedStatement.setFloat(3, room.getPrice());
            preparedStatement.setFloat(4, room.getRoomId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new HotelException("Failed to insert room: " + e.getMessage());
        }
    }
}
