package reservationPack;

import hotelPack.*;
import java.util.Date;

public class Reservation {
    private final String clientName;
    private Date checkInDate;
    private Date checkOutDate;
    private Room room;
    private static int count=0;
    private final int id;
    private boolean status;

    //constructor
    public Reservation(String clientName, Date checkInDate, Date checkOutDate, Room room){
        this.clientName=clientName;
        this.checkInDate=checkInDate;
        this.checkOutDate=checkOutDate;
        this.room=room;
        id=++count;
        this.status=true;
    }

    //getter

    public String getName(){
        return this.clientName;
    }

    public Date getDateCheckIn(){
        return this.checkInDate;
    }

    public Date getDateCheckOut(){
        return this.checkOutDate;
    }

    public Room getRoom(){
        return this.room;
    }

    public final int getID(){
        return this.id;
    }

    public boolean getStatus(){
        return this.status;
    }


    public void cancelReservation(){
        this.status=false;
    }

    //equals
    public boolean equals(Object reservation){
        if(reservation instanceof Reservation){
            return ((Reservation) reservation).getID()== this.getID();
        }
        return false;
    }

    public String toString(){
        return room.toString() + " "+ getDateCheckIn() + " - " + getDateCheckOut();
       }

}