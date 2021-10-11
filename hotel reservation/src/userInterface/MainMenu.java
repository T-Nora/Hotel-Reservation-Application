package userInterface;


import api.HotelResource;

import model.IRoom;
import model.Reservation;
import service.ReservationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class MainMenu {


    public static void mainMenu() {
        Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("1. Find and reserve a room" + "\n" + "2. See my reservations" + "\n" + "3. Create an account" + "\n" + "4. Admin" + "\n" + "5. Exit");
                System.out.println("Please select a number!");
                int userInput = Integer.parseInt(scanner.nextLine());

                switch (userInput) {
                    case 1:
                        /*
                        I learned more about SimpleDateFormat at:
                        https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
                        2021.07.26.
                        Apart from the course I learned more about setting a date at:
                        https://stackoverflow.com/questions/428918/how-can-i-increment-a-date-by-one-day-in-java
                        2021.07.24.
                         */


                        System.out.println("Find and reserve a room");
                        System.out.println("Please enter the date of arrival in the following format: dd/mm/yyyy!");
                        String checkInDate = scanner.nextLine();
                        Date inputDate1= new SimpleDateFormat("dd/MM/yyyy").parse(checkInDate);


                        System.out.println("Please enter the date of your departure int the following format: dd/mm/yyyy");
                        String checkOutDate = scanner.nextLine();
                        Date inputDate2 = new SimpleDateFormat("dd/MM/yyyy").parse(checkOutDate);

                        Collection<IRoom> allAvailableRooms = (HotelResource.getInstance().findARoom(inputDate1, inputDate2));

                        while (allAvailableRooms.size() == 0) {
                            System.out.println("This room is booked for the selected days, please choose another one!");


                            Calendar calendar = Calendar.getInstance();
                            calendar.setTime(inputDate1);
                            calendar.add(Calendar.DAY_OF_MONTH, 7);
                             inputDate1 = calendar.getTime();

                            Calendar calendarD = Calendar.getInstance();
                            calendarD.setTime(inputDate2);
                            calendarD.add(Calendar.DAY_OF_MONTH, 7);
                            inputDate2 = calendarD.getTime();

                            System.out.println("There are free room for the following time period: " + inputDate1 + "-"+inputDate2);
                             allAvailableRooms = HotelResource.getInstance().findARoom(inputDate1, inputDate2);

                        }
                        System.out.println(allAvailableRooms);
                        System.out.println("Do you have an account? Please type in Yes or No!");
                        String answer = scanner.nextLine();
                        HotelResource.getInstance().getCustomer(answer);

                        if(answer.equalsIgnoreCase("No")){
                            System.out.println("In order to book a room please create an account!");
                            MainMenu.mainMenu();
                        }
                        System.out.println("Please enter your email address!");
                        String emailAddress = scanner.nextLine();
                        System.out.println("Please type in the selected room number!");
                        String roomNumber = scanner.nextLine();

                        System.out.println(HotelResource.getInstance().bookARoom(emailAddress, HotelResource.getInstance().getRoom(roomNumber), inputDate1, inputDate2));

                        MainMenu.mainMenu();
                        break;
                    case 2:
                        System.out.println("See my reservations");
                        System.out.println("Please enter your email address in order to see your reservation(s)!");
                        String customerEmailSearch = scanner.nextLine();
                        Collection<Reservation> customerReservation =
                        HotelResource.getInstance().getCustomersReservations(customerEmailSearch);
                        for(Reservation reservation: customerReservation){
                        System.out.println(reservation + "\n");}
                        MainMenu.mainMenu();
                        break;
                    case 3:
                        System.out.println("Create an account");
                        System.out.println("Please enter your email address!");
                        String customerEmail = scanner.nextLine();
                        System.out.println("Please enter your first name!");
                        String customerFirstName = scanner.nextLine();
                        System.out.println("Please enter your last name!");
                        String customerLastName = scanner.nextLine();

                        HotelResource.getInstance().createACustomer(customerFirstName, customerLastName, customerEmail);

                        System.out.println("You created a new account!");

                        MainMenu.mainMenu();
                        break;
                    case 4:
                        System.out.println("Open Admin Menu");
                        AdminMenu.adminMenu();
                        break;
                    case 5:
                        System.out.println("You quit from the application!");

                        break;
                    default:
                        System.out.println("Please select a number between 1 and 5!");
                        MainMenu.mainMenu();
                        break;
                }
            } catch (IllegalArgumentException | ParseException ex) {
                System.out.println("\n Error - Invalid input \n");
                MainMenu.mainMenu();

            } finally {
                scanner.close();
            }
        }

    }


