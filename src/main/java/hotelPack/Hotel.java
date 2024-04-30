package hotelPack;

import java.util.ArrayList;
import reservationPack.Reservation;
import exceptionsPack.*;

public class Hotel
{
    // attributes
    private final int id;
    private String name;
    private final String address;
    private final String city;
    private final String state;
    private String phone;
    private String email;
    private static int cod = 0;
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
        this.id = cod++;
        rooms = new ArrayList<Room>();
        reservations = new ArrayList<Reservation>();
    }


    // methods to add rooms to array
    public void addRoomsByType(int nrOfRooms, String type, float price) throws AddRoomException
    {
        for(int i = 1; i <= nrOfRooms; i++)
        {
            if(!rooms.add(new Room(i, type, price)))
            {
                throw new AddRoomException("The room was not added.");
            }
        }
    }

    public void addRoomsByCapacity(int nrOfRooms, int capacity, float price) throws AddRoomException
    {
        for(int i = 1; i <= nrOfRooms; i++)
        {
            if(!rooms.add(new Room(i, capacity, price)))
            {
                throw new AddRoomException("The room was not added.");
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
        if(!reservations.contains(reservation))
        {
            if(!reservations.add(reservation))
            {
                throw new ReservationException("Failed to add the reservation.");
            }
        }
    }

    public void clearAllInactiveReservations()
    {
        reservations.removeIf(r -> !r.getStatus());
    }

    public void deleteReservation(Reservation reservation) throws ReservationException
    {
        if(reservations.contains(reservation))
        {
            if(!reservations.remove(reservation))
            {
                throw new ReservationException("Failed to delete the reservation.");
            }
            reservation.cancelReservation();
        }
    }


    // getters
    public int getId()
    {
        return id;
    }

    public String getAddress()
    {
        return address;
    }

     public String getName()
     {
         return name;
     }

     public String getCity()
     {
         return city;
     }

     public String getState()
     {
         return state;
     }

     public String getPhone()
     {
        return phone;
     }

    public String getEmail()
    {
        return email;
    }

    // setters

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public void setEmail(String email)
    {
        this.email = email;
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
