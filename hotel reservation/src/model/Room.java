package model;

public class Room implements IRoom{
   protected String roomNumber;
   protected Double price;
   protected RoomType enumeration;

    public Room(String roomNumber, Double price, RoomType enumeration){
        this.roomNumber = roomNumber;
        this.price = price;
        this.enumeration = enumeration;
    }


    public void setRoomNumber(String roomNumber){
        this.roomNumber = roomNumber;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public void setEnumeration(RoomType enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public String getRoomNumber() {
        return roomNumber;
    }

    @Override
    public Double getRoomPrice() {
        return price;
    }

    @Override
    public RoomType getRoomType() {
        return enumeration;
    }

    @Override
    public boolean isFree() {
        return false;
    }




    @Override
    public String toString(){
        return "The room number is: " + getRoomNumber() + "\n" + "The price of the selected room is: " + getRoomPrice() + "$"+ "\n" +"The type of the room is: " + getRoomType() +"\n" + "The room is free: " +isFree() ;
    }
}
