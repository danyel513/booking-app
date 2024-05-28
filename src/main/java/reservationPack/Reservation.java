package reservationPack;

import hotelPack.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public class Reservation {
    @Getter
    private final String clientName;
    private Date checkInDate;
    private Date checkOutDate;
    @Getter
    private Room room;
    @Setter
    private int id;
    private boolean status;

    //constructor
    public Reservation(String clientName, Date checkInDate, Date checkOutDate, Room room){
        this.clientName=clientName;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.room=room;
        this.status=true;
    }

    //getter

    public Date getDateCheckIn(){
        return this.checkInDate;
    }

    public Date getDateCheckOut(){
        return this.checkOutDate;
    }

    public final int getId(){
        return this.id;
    }

    public boolean getStatus(){
        return this.status;
    }

    public int getIntStatus()
    {
        if(this.status)
        {
            return 1;
        }
        return 0;
    }

    public void cancelReservation(){
        this.status=false;
    }

    //equals
    public boolean equals(Object reservation){
        if(reservation instanceof Reservation){
            return ((Reservation) reservation).getId()== this.getId();
        }
        return false;
    }

    public String toString(){
        return room.toString() + " "+ getDateCheckIn() + " - " + getDateCheckOut();
       }

}