# Hotel-Reservation-Application
I created this application at Udacity's Java Programming Nanodegree course.
The application allow customers to find and book a hotel room, based on room availability.

The user input is taken from the console, the application perform actions based on that.

The application is separated in 4 layers:

    -User Interface: includes main and admin menu.
    
    -Resources: acts as API to the UI.
    
    -Services: communicate with the resources, and each other, to build the business logic
               necessary to provide feedback to the UI.
               
    -Data models: used to represent the domain that is used by the system (e.g., rooms, reservations customers).
