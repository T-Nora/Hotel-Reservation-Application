package service;

import model.Customer;


import java.util.*;

public class CustomerService {

/*I learned more about providing a static reference, the use of singleton pattern at:
https://www.tutorialspoint.com/design_pattern/singleton_pattern.htm
2021.07.21.
    */
    private static CustomerService customerService;

    private CustomerService(){

    }
    public static CustomerService getInstance(){
        if(customerService == null){
            customerService = new CustomerService();
        }

        return  customerService;
    }


    HashSet<Customer> customersList = new HashSet<>();

    public void addCustomer(String email, String firstName, String lastName){

           try {
               customersList.add(new Customer(email, firstName, lastName));
           }
           catch (IllegalArgumentException ex){
               ex.getLocalizedMessage();
               System.out.println(ex.getLocalizedMessage());
           }
    }


    public Customer getCustomer(String customerEmail){
        try {for(Customer customer : customersList){
            if(customersList != null && customerEmail.equals(customer.getEmail())){
            System.out.println(customer);
            return customer;
           }
        } } catch (NoSuchElementException ex) {
                ex.getLocalizedMessage();
                System.out.println(ex.getLocalizedMessage());
                System.out.println("No customer was found based on that email address!");
        }

        return null;
    }


    public Collection<Customer> getAllCustomers(){
       for(Customer allCustomer: customersList){
            System.out.println(allCustomer + "\n");
        }
        return customersList;
    }
}
