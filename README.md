# Hotel Reservation System

A comprehensive hotel reservation platform built with Java Spring Boot, providing complete hotel management, room booking, and reservation handling capabilities.

## Features

- **User Management**
  - User registration and login
  - User profile management
  - User authentication

- **Hotel Management**
  - Add and manage hotels
  - Search hotels by city and name
  - Hotel information and amenities
  - Activate/deactivate hotels

- **Room Management**
  - Add and manage rooms
  - Room types: Single, Double, Suite, Deluxe, Penthouse
  - Room availability tracking
  - Room pricing management

- **Reservation System**
  - Create and manage reservations
  - Check-in/Check-out functionality
  - Availability checking
  - Reservation status tracking
  - Price calculation
  - Special requests handling

## Technology Stack

- **Backend**: Java 17, Spring Boot 3.1.5
- **Database**: H2 (In-memory for development)
- **ORM**: Hibernate JPA
- **Build Tool**: Maven 3.x
- **REST API**: Spring Web

## Project Structure

```
hotel-reservation-system/
├── src/
│   ├── main/
│   │   ├── java/com/hotelreservation/
│   │   │   ├── HotelReservationApplication.java (Main class)
│   │   │   ├── controller/
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── UserController.java
│   │   │   │   ├── HotelController.java
│   │   │   │   ├── RoomController.java
│   │   │   │   └── ReservationController.java
│   │   │   ├── service/
│   │   │   │   ├── UserService.java
│   │   │   │   ├── HotelService.java
│   │   │   │   ├── RoomService.java
│   │   │   │   └── ReservationService.java
│   │   │   ├── repository/
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── HotelRepository.java
│   │   │   │   ├── RoomRepository.java
│   │   │   │   └── ReservationRepository.java
│   │   │   └── model/
│   │   │       ├── User.java
│   │   │       ├── Hotel.java
│   │   │       ├── Room.java
│   │   │       ├── RoomType.java
│   │   │       ├── Reservation.java
│   │   │       └── ReservationStatus.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
└── pom.xml
```

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Windows, Linux, or macOS

## Installation

1. Clone or extract the project
2. Navigate to the project directory
3. Build the project with Maven:

```bash
mvn clean install
```

## Running the Application

Run the application using Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Documentation

### Authentication Endpoints

- **POST** `/api/auth/register` - Register a new user
- **POST** `/api/auth/login` - Login user

### User Endpoints

- **GET** `/api/users/{id}` - Get user by ID
- **GET** `/api/users` - Get all users
- **PUT** `/api/users/{id}` - Update user profile
- **DELETE** `/api/users/{id}` - Delete user

### Hotel Endpoints

- **POST** `/api/hotels` - Add new hotel
- **GET** `/api/hotels/{id}` - Get hotel by ID
- **GET** `/api/hotels` - Get all hotels
- **GET** `/api/hotels/active/list` - Get active hotels
- **GET** `/api/hotels/city/{city}` - Get hotels by city
- **GET** `/api/hotels/search/{name}` - Search hotels by name
- **PUT** `/api/hotels/{id}` - Update hotel
- **DELETE** `/api/hotels/{id}` - Delete hotel
- **PUT** `/api/hotels/{id}/deactivate` - Deactivate hotel

### Room Endpoints

- **POST** `/api/rooms` - Add new room
- **GET** `/api/rooms/{id}` - Get room by ID
- **GET** `/api/rooms/hotel/{hotelId}` - Get rooms by hotel
- **GET** `/api/rooms/hotel/{hotelId}/available` - Get available rooms
- **GET** `/api/rooms/type/{roomType}` - Get rooms by type
- **PUT** `/api/rooms/{id}` - Update room
- **DELETE** `/api/rooms/{id}` - Delete room
- **PUT** `/api/rooms/{id}/mark-unavailable` - Mark room unavailable
- **PUT** `/api/rooms/{id}/mark-available` - Mark room available

### Reservation Endpoints

- **POST** `/api/reservations` - Create reservation
- **GET** `/api/reservations/{id}` - Get reservation by ID
- **GET** `/api/reservations/user/{userId}` - Get user reservations
- **GET** `/api/reservations/room/{roomId}` - Get room reservations
- **GET** `/api/reservations/status/{status}` - Get reservations by status
- **GET** `/api/reservations/date-range?startDate=YYYY-MM-DD&endDate=YYYY-MM-DD` - Get reservations by date range
- **PUT** `/api/reservations/{id}` - Update reservation
- **PUT** `/api/reservations/{id}/confirm` - Confirm reservation
- **PUT** `/api/reservations/{id}/check-in` - Check-in to reservation
- **PUT** `/api/reservations/{id}/check-out` - Check-out from reservation
- **PUT** `/api/reservations/{id}/cancel` - Cancel reservation
- **DELETE** `/api/reservations/{id}` - Delete reservation

## Database

### H2 Console

Access H2 console at: `http://localhost:8080/h2-console`

- URL: `jdbc:h2:mem:hotelreservationdb`
- Username: `sa`
- Password: (leave blank)

## Sample Data

Sample data can be added through the REST API endpoints after starting the application.

## Configuration

Modify `application.properties` to change:

- Server port
- Database settings
- Logging levels
- JPA/Hibernate configuration

## Error Handling

The API returns standard HTTP status codes:

- **200 OK** - Successful request
- **201 Created** - Resource created successfully
- **400 Bad Request** - Invalid input
- **404 Not Found** - Resource not found
- **409 Conflict** - Room not available for dates
- **500 Internal Server Error** - Server error

## Future Enhancements

- User authentication with JWT
- Payment integration
- Email notifications
- Booking confirmation emails
- Admin dashboard
- Review and rating system
- Multi-language support
- Advanced search and filtering
- Discount codes
- Loyalty programs

## License

This project is open source and available under the MIT License.

## Support

For support and questions, please create an issue in the project repository.

---

**Happy Booking!** 🏨
