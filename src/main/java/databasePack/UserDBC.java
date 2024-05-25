package databasePack;

import exceptionsPack.HotelException;
import exceptionsPack.UserException;
import userPack.User;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import static queries.Queries.INSERT_USER_QUERY;

public class UserDBC
{
    private final Connection connection;

    public UserDBC() throws UserException
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
            throw new UserException(e.getMessage());
        }
    }

    public void insert(User user) throws HotelException
    {
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_QUERY))
        {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhoneNumber());
            // password encryption
            String encryptedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            preparedStatement.setString(4, encryptedPassword);
            preparedStatement.setInt(5, user.getReservation().getId());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new HotelException("Database could not be accessed: " + e.getMessage());
        }
    }

    public boolean checkPassword(String plainPassword, String hashedPassword) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }
}
