# 📝 NOTES.md

# 🏨 Hotel Reservation System - Notes

A simple Java Spring Boot application for managing hotels, rooms, users, and reservations. It allows users to book rooms, manage hotels, and handle reservations efficiently.

---

# 🎯 Project Objectives

✅ Manage hotel information 🏨

✅ Manage room availability 🛏️

✅ Register and manage users 👤

✅ Book hotel rooms 📅

✅ Track reservation status 📋

✅ Calculate booking prices 💰

---

# 🛠️ Technologies Used

* ☕ Java 17
* 🌱 Spring Boot 3.1.5
* 🗄️ Spring Data JPA (Hibernate)
* 💾 H2 Database
* 📦 Maven
* 🌐 REST API

---

# 📂 Project Structure

```text
hotel-reservation-system/
│
├── controller/       🌐 REST Controllers
├── service/          ⚙️ Business Logic
├── repository/       🗄️ Database Access
├── model/            📦 Entity Classes
├── resources/        📄 Configuration Files
└── pom.xml           📦 Maven Dependencies
```

---

# 📚 Main Modules

## 👤 User Management

Features:

* 📝 Register new users
* 🔑 Login users
* 👤 Update user profile
* ❌ Delete user
* 📋 View user details

---

## 🏨 Hotel Management

Features:

* ➕ Add hotels
* ✏️ Update hotel information
* ❌ Delete hotels
* 🔍 Search hotels
* 📍 Search by city
* 🏨 Activate or deactivate hotels

---

## 🛏️ Room Management

Features:

* ➕ Add rooms
* ✏️ Update room details
* 💲 Set room prices
* 📋 View available rooms
* 🚫 Mark rooms unavailable
* ✅ Mark rooms available

### 🛏️ Room Types

* 🛌 Single
* 👥 Double
* 🌟 Suite
* 💎 Deluxe
* 👑 Penthouse

---

## 📅 Reservation Management

Features:

* 📝 Create reservations
* ✅ Confirm booking
* 🏨 Check-In
* 🚪 Check-Out
* ❌ Cancel reservation
* 💰 Calculate booking cost
* 📋 Track reservation status
* 💬 Store special requests

---

# 📦 Entity Classes

### 👤 User

Stores:

* User ID
* Name
* Email
* Password
* Contact Information

---

### 🏨 Hotel

Stores:

* Hotel Name
* City
* Address
* Amenities
* Active Status

---

### 🛏️ Room

Stores:

* Room Number
* Room Type
* Price
* Availability

---

### 📅 Reservation

Stores:

* Reservation ID
* User
* Hotel
* Room
* Check-In Date
* Check-Out Date
* Total Price
* Reservation Status

---

# 📊 Reservation Status

* 🟡 Pending
* ✅ Confirmed
* 🏨 Checked-In
* 🚪 Checked-Out
* ❌ Cancelled

---

# 🌐 REST API Modules

### 🔐 Authentication

* Register User
* Login User

---

### 👤 User API

* Get User
* Update User
* Delete User
* View All Users

---

### 🏨 Hotel API

* Add Hotel
* Update Hotel
* Delete Hotel
* Search Hotels
* View Hotels

---

### 🛏️ Room API

* Add Room
* Update Room
* Delete Room
* View Rooms
* Available Rooms

---

### 📅 Reservation API

* Create Reservation
* Update Reservation
* Confirm Booking
* Cancel Booking
* Check-In
* Check-Out
* Reservation History

---

# 💾 Database

Database Used:

🗄️ H2 In-Memory Database

### H2 Console

* 🌐 URL: `http://localhost:8080/h2-console`
* 💾 JDBC URL: `jdbc:h2:mem:hotelreservationdb`
* 👤 Username: `sa`
* 🔒 Password: *(Leave Blank)*

---

# ▶️ How to Run

### Compile

```bash
mvn clean install
```

### Start Application

```bash
mvn spring-boot:run
```

Application URL:

```
http://localhost:8080
```

---

# ⚙️ Features Summary

✅ User Registration 👤

✅ User Login 🔑

✅ Hotel Management 🏨

✅ Room Management 🛏️

✅ Room Availability ✔️

✅ Reservation System 📅

✅ Check-In / Check-Out 🏨

✅ Booking Cancellation ❌

✅ Price Calculation 💰

✅ Search Hotels 🔍

---

# 🛡️ Error Handling

| Status Code | Meaning               |
| ----------- | --------------------- |
| ✅ 200       | Request Successful    |
| 🆕 201      | Resource Created      |
| ⚠️ 400      | Bad Request           |
| 🔍 404      | Resource Not Found    |
| 🚫 409      | Room Not Available    |
| 💥 500      | Internal Server Error |

---

# 📖 Java Concepts Used

* ☕ Java
* 🌱 Spring Boot
* 📦 Maven
* 🗄️ Hibernate JPA
* 📂 Repository Pattern
* 🧩 Object-Oriented Programming
* 🌐 REST APIs
* 📋 CRUD Operations
* 💾 Database Management

---

# 🚀 Future Improvements

✨ JWT Authentication

✨ Payment Gateway 💳

✨ Email Notifications 📧

✨ Booking Confirmation Email 📩

✨ Admin Dashboard 📊

✨ Reviews & Ratings ⭐

✨ Multi-language Support 🌍

✨ Advanced Search 🔍

✨ Discount Coupons 🎁

✨ Loyalty Program 🏆

---

# ⚠️ Limitations

* ❌ Uses H2 in-memory database (data is lost after restart).
* ❌ No online payment integration.
* ❌ No email notifications.
* ❌ No admin dashboard.
* ❌ No review system.

---

# 📚 Learning Outcomes

After completing this project, you will learn:

* ☕ Java Spring Boot
* 🌐 REST API Development
* 🗄️ Database Connectivity
* 📦 Maven Project Structure
* 🧩 Object-Oriented Programming
* 💾 Hibernate JPA
* 🔄 CRUD Operations
* 🏨 Hotel Reservation Workflow

---

# ❤️ Project Information

📌 **Project:** Hotel Reservation System

☕ **Language:** Java

🌱 **Framework:** Spring Boot

🗄️ **Database:** H2

📦 **Build Tool:** Maven

🚀 **Version:** 1.0

🏨 **Happy Booking & Happy Coding! 👨‍💻👩‍💻✨**

For support and questions, please create an issue in the project repository.

---

**Happy Booking!** 🏨
