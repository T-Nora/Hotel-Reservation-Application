package api;

import model.Customer;
import model.IRoom;
import service.CustomerService;
import service.ReservationService;

import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;

public class AdminResource {

    private static AdminResource adminResource;
    private AdminResource(){};
    public static AdminResource getInstance(){
        if(adminResource == null){
            adminResource = new AdminResource();
        }
        return adminResource;
    }

   public Customer getCustomer(String email){
        return CustomerService.getInstance().getCustomer(email);
    }
    public void addRoom(List<IRoom> rooms){
        for(IRoom room : rooms){
            ReservationService.getInstance().addRoom(room);
        }
    }
    public Collection<IRoom> getAllRooms(){
       if(ReservationService.getInstance().getGetRoomList().size() == 0){
           throw new NoSuchElementException();
       }

        return ReservationService.getInstance().getGetRoomList();

    }

    public Collection<Customer> getAllCustomers(){
        if(CustomerService.getInstance().getAllCustomers().size() == 0){
            throw new NoSuchElementException();
        }
        return CustomerService.getInstance().getAllCustomers();
    }
    public void displayAllReservations(){
         ReservationService.getInstance().printAllReservation();


    }
}
