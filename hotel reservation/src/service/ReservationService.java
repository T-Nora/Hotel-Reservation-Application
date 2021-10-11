package service;

import model.Customer;
import model.IRoom;
import model.Reservation;
import model.Room;

import java.util.*;

public class ReservationService {
    /*I learned more about providing a static reference, the use of singleton pattern at:
    https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
    2021.07.21.
        */
    private static ReservationService reservationService;

    private ReservationService() {
    }

    public static ReservationService getInstance() {
        if (reservationService == null) {
            reservationService = new ReservationService();
        }
        return reservationService;
    }

     Collection<IRoom> roomList = new HashSet<>();


    public void addRoom(IRoom room) {
        room = new Room(room.getRoomNumber(), room.getRoomPrice(), room.getRoomType());
        if (roomList.contains(room)) {
            System.out.println("This room is already contained by the room list. To broaden the list please enter another number!");
        } else {
            roomList.add(room);
            System.out.println("The room was added to the list!");
        }

    }


      Collection<IRoom> getRoomList() {
        return roomList;
    }
    public Collection<IRoom> getGetRoomList(){
        return getRoomList();
    }

     public IRoom getARoom(String roomId) {
      try {
          for (IRoom room : roomList) {
              if (roomId.equals(room.getRoomNumber())) {
                  System.out.println(room);
                  return room;
              }
          }
      } catch (NoSuchElementException ex) {
          System.out.println(ex.getLocalizedMessage());
      }
        return null;
    }


    Collection<Reservation> reservedRooms = new HashSet<>();

    public Reservation reserveARoom(Customer customer, IRoom room, Date checkInDate, Date checkOutDate) {
        Reservation bookedRoom = new Reservation(customer, room, checkInDate, checkOutDate);
        reservedRooms.add(bookedRoom);
        System.out.println("Thank you for your reservation! The details of the reservation: " + "\n" + "Customer: " + customer + "\n" + "The selected room: " + room + "\n" + "Date of arrival: " + checkInDate + "Date of departure: " + checkOutDate);
        return bookedRoom;
    }


    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        Collection<IRoom> allAvailableRooms = new HashSet<>();
        for (IRoom room : roomList) {
            boolean available = true;
            for (Reservation reservation : reservedRooms) {

                if (reservation.getRoom().getRoomNumber().equals(room.getRoomNumber())) {
                    if (checkInDate.after(reservation.getCheckInDate()) && checkInDate.before(reservation.getCheckOutDate())) {

                        available = false;
                    }
                    if (checkOutDate.after(reservation.getCheckInDate()) && checkOutDate.before(reservation.getCheckOutDate())) {

                        available = false;
                    }
                    if(checkInDate.equals(reservation.getCheckInDate()) || checkInDate.equals(reservation.getCheckOutDate())){
                        available = false;
                    }
                    if(checkOutDate.equals(reservation.getCheckInDate()) || checkOutDate.equals(reservation.getCheckOutDate())){
                        available = false;
                    }
                }
            }
            if (available) {
                allAvailableRooms.add(room);

            }

        }


        return allAvailableRooms;
    }



    public Collection<Reservation> getCustomersReservation(Customer customer) {
        Collection<Reservation> customerReservation = new HashSet<>();
        for (Reservation rooms : reservedRooms) {
            if (customer.equals(rooms.getCustomer())) {
                customerReservation.add(rooms);
            }
        }
        return customerReservation;
    }



    public void printAllReservation() {
        if (!(reservedRooms == null)) {
            System.out.println(reservedRooms);
        } else {
            System.out.println("There are no reservations yet!");
        }
    }
}
