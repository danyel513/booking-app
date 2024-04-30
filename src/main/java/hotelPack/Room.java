package hotelPack;

public class Room
{
    // all attributes
    private final int roomNumber;
    private int capacity;
    private float price;
    private boolean available;

    //constructors
    public Room(int roomNumber, int capacity, float price)
    {
        this.roomNumber = roomNumber;
        if(capacity < 1)
        {
            this.capacity = 0;
        }
        else
        {
            this.capacity = capacity;
        }
        this.price = price;
        this.available = true;
    }

    public Room(int roomNumber, String type, float price)
    {
        this.roomNumber = roomNumber;
        switch (type) {
            case "Single" -> this.capacity = 1;
            case "Double" -> this.capacity = 2;
            case "Triple" -> this.capacity = 3;
            case "Two Double Beds" -> this.capacity = 4;
            case "Apartment" -> this.capacity = 5;
            default -> this.capacity = 0;
        }
        this.price = price;
    }


    // getters
    public int getRoomNumber()
    {
        return roomNumber;
    }

    public float getPrice()
    {
        return price;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public boolean getAvailability()
    {
        return available;
    }

    // setters
    public void changeAvailability()
    {
        this.available = !this.available;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    // convert capacity into room type
    public String roomType()
    {
        if(capacity == 0)
        {
            return "Unavailable";
        }

        if(this.capacity == 1)
        {
            return "Single";
        }

        if(this.capacity == 2)
        {
            return "Double";
        }

        if(this.capacity == 3)
        {
            return "Triple";
        }

        if(this.capacity == 4)
        {
            return "Two Double Beds";
        }

        if(this.capacity > 4)
        {
            return "Apartment";
        }

        return "";
    }


    // overwrite useful methods

    public String toString()
    {
        return "RoomNumber: " + roomNumber + ", Capacity: " + capacity + ", Price: " + price;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof Room)
        {
            return this.getRoomNumber() == ((Room) obj).getRoomNumber() && this.getCapacity() == ((Room) obj).getCapacity() && this.getPrice() == ((Room) obj).getPrice();
        }
        return false;
    }
}
