package hotelPack;

import exceptionsPack.RoomException;
import exceptionsPack.ReservationException;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;
import reservationPack.Reservation;

import java.util.ArrayList;
import java.util.Objects;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
@SuperBuilder
public class Hotel
{

    // getters
    // attributes
    @Getter
    @Id
    @Setter
    private int id;
    @Setter
    @Getter
    @NotEmpty(message = "Name cannot be empty.")
    private String name;
    @Getter
    @NotEmpty(message = "Address cannot be empty.")
    private final String address;
    @Getter
    @NotEmpty(message = "City cannot be empty.")
    private final String city;
    @Getter
    @NotEmpty(message = "State cannot be empty.")
    private final String state;
    @Setter
    @Getter
    private String phone;
    @Setter
    @Getter
    @NotEmpty(message = "Email cannot be empty.")
    private String email;
    private final ArrayList<Room> rooms;
    private final ArrayList<Reservation> reservations;

    // constructor
    public Hotel(String name, String address, String city, String state, String phone, String email)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.email = email;
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
    }


    // methods to add rooms to array
    public void addRoomsByType(int nrOfRooms, String type, float price) throws RoomException
    {
        for(int i = 1; i <= nrOfRooms; i++)
        {
            if(!rooms.add(new Room(i, type, price)))
            {
                throw new RoomException("The room was not added.");
            }
        }
    }

    public void addRoomsByCapacity(int nrOfRooms, int capacity, float price) throws RoomException
    {
        for(int i = 1; i <= nrOfRooms; i++)
        {
            if(!rooms.add(new Room(i, capacity, price)))
            {
                throw new RoomException("The room was not added.");
            }
        }
    }

    // manage rooms methods
    public String getAvailableRooms()
    {
        StringBuilder output = new StringBuilder();
        for (Room r : rooms)
        {
            if (r.getAvailability()) {
                output.append(r).append("\n");
            }
        }
        return output.toString();
    }

    public String getAllRooms()
    {
        StringBuilder output = new StringBuilder();
        for(Room r : rooms)
        {
            output.append(r.toString()).append("\n");
        }
        return output.toString();
    }

    public void maintenanceRoom(Room room)
    {
        for(Room r : rooms)
        {
            if(r.equals(room))
            {
                r.changeAvailability();
                break;
            }
        }
    }

    public void maintenanceRoom(int roomNumber, int capacity, float price)
    {
        Room room = new Room(roomNumber, capacity, price);
        for(Room r : rooms)
        {
            if(r.equals(room))
            {
                r.changeAvailability();
                break;
            }
        }
    }

    // reservations manage methods
    public void addReservation(Reservation reservation) throws ReservationException
    {
        if (reservations == null) throw new AssertionError();
        if(!reservations.contains(reservation))
        {
            if(!reservations.add(reservation))
                throw new ReservationException("Failed to add the reservation.");
        }
    }

    public void clearAllInactiveReservations()
    {
        Objects.requireNonNull(reservations).removeIf(r -> !r.getStatus());
    }

    public void deleteReservation(Reservation reservation) throws ReservationException
    {
        if (reservations == null) throw new AssertionError();
        if(reservations.contains(reservation))
        {
            if(!reservations.remove(reservation))
            {
                throw new ReservationException("Failed to delete the reservation.");
            }
            reservation.cancelReservation();
        }
    }

    // basic methods overwrite
    public boolean equals(Object hotel)
    {
        if(hotel instanceof Hotel)
        {
            return ((Hotel) hotel).getId() == this.getId();
        }
        return false;
    }

    public String toString()
    {
        return getName() + " " + getAddress() + " " + getCity() + " " + getState();
    }

}
