package userInterface;

import api.AdminResource;

import model.IRoom;
import model.Room;
import model.RoomType;


import java.util.*;

public class AdminMenu {

    public static void adminMenu() {
        Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("1. See all Customers" + "\n" + "2. See all Rooms" + "\n" + "3. See all Reservations" + "\n" + "4. Add a Room" + "\n" + "5. Back to Main Menu");
                System.out.println("Please select a number!");
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        System.out.println("See all Customers");

                        try {
                          AdminResource.getInstance().getAllCustomers();

                        } catch (NoSuchElementException e) {
                            System.out.println("There are no customers in the system yet!");

                        }
                        AdminMenu.adminMenu();
                        break;
                    case 2:
                        System.out.println("See all Rooms");
                      try {
                          Collection<IRoom> allBookedRooms = AdminResource.getInstance().getAllRooms();
                          for (IRoom room : allBookedRooms) {
                              System.out.println(room + "\n");
                          }
                      } catch (NoSuchElementException ex){
                          System.out.println("There are no rooms in the system yet!");
                      }
                        AdminMenu.adminMenu();

                        break;
                    case 3:
                        System.out.println("See all reservations");
                        try {
                            AdminResource.getInstance().displayAllReservations();
                        } catch (NoSuchElementException e) {
                            System.out.println("There are no reservations in the system yet!");

                        }
                        AdminMenu.adminMenu();
                        break;
                    case 4:
                        boolean addNewRoom = true;
                        do {
                            System.out.println("Add a Room" + "\n" + "Please enter a room number!");
                            String roomNumber = scanner.nextLine();

                            System.out.println("Please enter the price per night!");
                            Double priceOfRoomPerNight = scanner.nextDouble();

                            System.out.println("Please select the required room type! 1 means SINGLE room, 2 means DOUBLE room!");
                            int bedType = scanner.nextInt();
                            if (bedType > 2) {
                                System.out.println("Please type in a valid number: 1-SINGLE, 2-DOUBLE");
                            } else {
                                RoomType roomType = bedType == 1 ? RoomType.SINGLE : RoomType.DOUBLE;

                                IRoom room = new Room(roomNumber, priceOfRoomPerNight, roomType);
                                List<IRoom> rooms = new ArrayList<>() {
                                };
                                rooms.add(room);
                                AdminResource.getInstance().addRoom(rooms);
                                System.out.println(rooms);

                            }


                            System.out.println("Would you like to add another room? Please type in Yes or No!");
                            String addNew = scanner.nextLine();
                            if (scanner.nextLine().equalsIgnoreCase("No")) {
                                addNewRoom = false;
                                AdminMenu.adminMenu();
                            }
                        } while (addNewRoom);
                        break;
                    case 5:
                        System.out.println("Get back to the Main Menu");
                        MainMenu.mainMenu();
                    default:
                        System.out.println("PLease type in a valid number, between 1 and 5!");

                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("PLease type in a valid number, between 1 and 5!");
                AdminMenu.adminMenu();

            } finally {
                scanner.close();
            }
        }
    }



