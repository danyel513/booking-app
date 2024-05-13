package userPack;
import exceptionsPack.*;
import lombok.Getter;
import lombok.Setter;
import reservationPack.*;

public class User
{
    private String name;
    private final String email;
    private String phoneNumber;
    private String password;
    @Getter
    @Setter
    private Reservation reservation;
    @Setter
    private int userId;


    //constructor
    public User(String name, String email, String phoneNumber, String password){
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.password=password;
    }

    //getter
    public String getName(){
        return this.name;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getPassword(){
        return this.password;
    }

    //setter

    public void setName(String name){
        this.name=name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber=phoneNumber;
    }

    private void setPassword(String password){
        this.password=password;
    }


    //equals
    public boolean equals(Object user){
        if(user instanceof User){
            return ((User) user).getName()== this.getName();
        }
        return false;
    }

    //toString
    public String toString(){
        return getName()+" "+getEmail();
    }

    public void changePassword(String password) throws PasswordException{
        if(password.length()>=8){
            this.setPassword(password);
        }
        else{
            throw new PasswordException("The password does not meet the requirements!");
        }
    }

}