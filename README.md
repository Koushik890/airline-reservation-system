# Airline Reservation System

Welcome to the Airline Reservation System project! This system is designed to manage various operations related to airline reservations, including booking flights, managing customer details, generating boarding passes, and more.

## Features

- **Customer Management**: Add, update, and view customer details.
- **Flight Booking**: Book flights for customers, view available flights, and fetch user details.
- **Boarding Pass**: Generate and print boarding passes for customers.
- **Ticket Cancellation**: Cancel booked tickets and manage cancellation details.
- **Flight Information**: View and manage flight details.
- **Journey Details**: Fetch and display journey details based on PNR.

## Technologies Used

- **Java**: The core programming language used to develop the application.
- **Swing**: Java's GUI widget toolkit used for creating the graphical user interface.
- **MySQL**: The relational database management system used for storing and managing the application's data.
- **JDBC**: Java Database Connectivity API used to connect and execute queries with the MySQL database.
- **NetBeans**: The integrated development environment (IDE) used for developing and building the project.
- **Ant**: The build tool used to automate the build process (via `build.xml`).

## Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/Koushik890/airline-reservation-system.git
    ```
2. **Navigate to the project directory**:
    ```bash
    cd airline-reservation-system
    ```
3. **Set up the database**:
    - Create a MySQL database named `airlinereservationsystem`:
      ```sql
      CREATE DATABASE airlinereservationsystem;
      ```
    - Use the following SQL scripts to create the required tables:
      ```sql
      CREATE TABLE login (
          username VARCHAR(20),
          password VARCHAR(20)
      );

      CREATE TABLE passenger (
          name VARCHAR(20),
          nationality VARCHAR(20),
          gender VARCHAR(20),
          aadhar VARCHAR(20),
          address VARCHAR(50),
          phone VARCHAR(15),
          email VARCHAR(50)
      );

      CREATE TABLE flight (
          f_code VARCHAR(20),
          f_name VARCHAR(20),
          source VARCHAR(40),
          destination VARCHAR(40)
      );

      CREATE TABLE reservation (
          PNR VARCHAR(15),
          TICKET VARCHAR(20),
          aadhar VARCHAR(20),
          name VARCHAR(20),
          nationality VARCHAR(30),
          flightname VARCHAR(20),
          flightcode VARCHAR(20),
          src VARCHAR(30),
          dest VARCHAR(30),
          dateTravel VARCHAR(30)
      );

      CREATE TABLE cancel (
          pnr VARCHAR(15),
          name VARCHAR(20),
          cancelno VARCHAR(20),
          flightname VARCHAR(20),
          datetravel VARCHAR(30),
          source VARCHAR(30),
          destination VARCHAR(30)
      );
      ```

4. **Configure the database connection**:
    - Update the `ConnectionDB.java` file with your database credentials:
      ```java
      c = DriverManager.getConnection("jdbc:mysql:///airlinereservationsystem", "username", "password");
      ```

5. **Build and run the project**:
    - Open the project in NetBeans (or any other Java IDE supporting Ant builds).
    - Clean and build the project using the provided `build.xml` file.
    - Run the `Home.java` file to start the application.

## Usage

- **Login**: Start by logging in using your credentials.
- **Navigation**: Use the main menu to navigate through different functionalities:
  - **Details**: Access customer and flight details.
  - **Ticket**: Manage boarding passes and ticket cancellations.

## Project Structure

- **src/airlinereservationsystem**: Contains the Java source files for different modules like `AddCustomer`, `BoardingPass`, `BookFlight`, `CancelTicket`, `ConnectionDB`, `FlightInfo`, `Home`, `JourneyDetails`, and `Login`.
- **build.xml**: The Ant build script automates the build process.
- **nbproject**: NetBeans-specific project configuration files.
- **Icons and Images**: These are located in `src/airlinereservationsystem/icons` and used in the user interface.

## Contributing

Contributions are welcome! Please follow these steps to contribute:

1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Commit your changes (`git commit -m 'Add some feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a pull request.
