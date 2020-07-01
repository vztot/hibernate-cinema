# hibernate-cinema [![Build Status](https://travis-ci.com/vztot/hibernate-cinema.svg?branch=master)](https://travis-ci.com/vztot/hibernate-cinema)

## Project purpose
This is a simple REST service with authentication for ticket booking.

You can register and login. While authenticated you can use several user services.
Also, there are specific controllers to manage data available only for admin.

User can complete order and add tickets to shopping cart.
Admin can add new movies, movie sessions and cinema halls.

## Project Structure
* Java 11
* Maven
* Hibernate
* Spring
* Spring Security
* Maven checkstyle plugin
* Lombok

## For developer

1. Open the project in your IDE.

2. Add Java SDK 11 or above.

3. Configure Tomcat:
   * add the artifact cinema-project:war;
   * configure root URL to http://localhost:8080/

4. MySQL
   * install MySQL server
   * configure db.properties
   * connect to MySQL server
   * execute ``CREATE SCHEMA `cinema` DEFAULT CHARACTER SET utf8"``

5. Run the project.

6. For testing download Postman or analogue.

7. For authorization, you must add a new header, where Authorization is key and Basic email
:password is value, where email:password must be encoded to Base64 format.

There are test data that you can use.
There’s already registered USER and ADMIN:
 * `email = "admin@gmail.com", password = "1111"`
 * `email = "user@gmail.com", password = "2222"`
 
You can change these test data in InjectDataController.

## Author

[Oleksandr Husenko](https://www.linkedin.com/in/oleksandr-husenko-6a63a2b3/)
