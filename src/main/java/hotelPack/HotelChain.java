package hotelPack;

import java.util.ArrayList;
import reservationPack.Reservation;
import exceptionsPack.*;

public class HotelChain
{
    private String name;
    private String phoneNumber;
    private String email;
    private ArrayList<Hotel> hotels;
    private ArrayList<Reservation> reservations;

    // constructor
    public HotelChain(String name, String phoneNumber, String email)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        hotels = new ArrayList<Hotel>();
        reservations = new ArrayList<Reservation>();
    }

    // reservation manage methods
    public void processReservation(Reservation reservation) throws ReservationException
    {
        if(!reservations.contains(reservation))
        {
            if(!reservations.add(reservation))
            {
                throw new ReservationException("Failed to make a new reservation.");
            }

        }
    }

    // add the hotels
    public void addHotel(Hotel hotel) throws HotelException
    {
        if(!hotels.contains(hotel))
        {
            if(!hotels.add(hotel))
            {
                throw new HotelException("Failed to add a new hotel.");
            }
        }
    }

    public void addHotel(String name, String address, String city, String state, String phone, String email) throws HotelException
    {
        Hotel hotel = new Hotel(name, address, city, state, phone, email);
        if(!hotels.contains(hotel))
        {
            if(!hotels.add(hotel))
            {
                throw new HotelException("Failed to add a new hotel.");
            }
        }
    }

    public void deleteHotel(Hotel hotel) throws HotelException
    {
        if (hotels.contains(hotel))
        {
            if (!hotels.remove(hotel))
            {
                throw new HotelException("Failed to delete the hotel.");
            }
        }
    }


    // getters
    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    // setters
    public void setName(String name)
    {
        this.name = name;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
}
