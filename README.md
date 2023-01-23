# BRMS
This project is about Bus Reservation Management System 
## Technologies I have used to implement BRMS project:
  - Core java, 
  - MySQL database, 
  - Maven,
  - Logger, 
  - JDBC. 
  
In this project my module is BusReservation.
- In BusReservation there will be two choices,
      -- one is booking the ticket and 
      -- another one is view the ticket using unique id. 

- In BusReservation the user enters the source and destination , it will display all the Buses with their Bus details including Bus Registration number ,by choosing the Bus Registration number , the number of available seats and booked seats will be displayed.

- From that data the user can select the available seats and by selecting one of the seats , the ticket will be booked and an unique ticket id will be generated and the reservation date and time will be displayed with the full details of the user .

- For each reservation , Confirmation Ticket will be generated with a Unique Ticket Number.
Confirmed Ticket will displayed by Date of travel, source, destination, time of start, reach time, Details of passenger, reservation date/time, ticket charges.

-After getting details of booking for confirmation we have to enter the loginid and password of the user.

- The other choice is getting the details by entering the reservation ticket unique id.

- When user enter the unique id , if the unique id matches in the database then all the details will be displayed on the screen other wise it will shows the details are not found.
