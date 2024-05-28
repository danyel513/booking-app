package queries;

public class Queries
{
    public static final String INSERT_HOTEL_QUERY = "INSERT INTO Hotels (name, address, city, state, phone, email) VALUES (?, ?, ?, ?, ?, ?)";
    public static final String INSERT_RESERVATION_QUERY = "INSERT INTO reservations (clientName, checkInDate, checkOutDate, roomId) VALUES (?, ?, ?, ?)";
    public static final String INSERT_ROOM_QUERY = "INSERT INTO rooms (roomNumber, capacity, price, roomId) VALUES (?, ?, ?, ?)";
    public static final String INSERT_USER_QUERY = "INSERT INTO users (name, email, phoneNumber, password, reservationId) VALUES (?, ?, ?, ?, ?)";
}
