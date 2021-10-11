package model;

import java.util.Date;
import java.util.Objects;

public class Reservation {
    private final Customer customer;
    private final IRoom room;
    private final Date checkInDate;
    private final Date checkOutDate;

    public Reservation(Customer customer, IRoom room, Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.room = room;
        this.checkInDate= checkInDate;
        this.checkOutDate = checkOutDate;
    }


    public Customer getCustomer() {

        return customer;
    }

    /*public void setCustomer(Customer customer) {
        this.customer = customer;
    }*/

    public IRoom getRoom() {
        return room;
    }

   /* public void setRoom(IRoom room) {
        this.room = room;
    }*/

    public Date getCheckInDate() {

        return checkInDate;
    }

   /* public void setCheckInDate(Date checkInDate) {

        this.checkInDate = checkInDate;

    }*/

    public Date getCheckOutDate() {

        return checkOutDate;
    }

   /* public void setCheckOutDate(Date checkOutDate) {

        this.checkOutDate = checkOutDate;
    }*/

    @Override
    public boolean equals(Object object){
        if(this == object){
            return true;
        }
        if(!(object instanceof Customer)){
            return false;
        }
        Reservation first = (Reservation) object;
        if(!this.getCustomer().equals(first.getCustomer())){
            return false;
        } else if(!this.getRoom().equals(first.getRoom())){
            return false;
        } else if(!this.getCheckInDate().equals(first.getCheckInDate())){
            return false;
        }else if(!this.getCheckOutDate().equals(first.getCheckOutDate())){
            return false;
        }
        return true;
    }
    @Override
    public int hashCode(){
        return Objects.hash(customer, room, checkInDate, checkOutDate);
    }
    @Override
    public String toString(){
        return "Customer: " + customer + " Selected room: " + room + " Date of arrival and departure: " + checkInDate + "-" + checkOutDate;
    }
}
