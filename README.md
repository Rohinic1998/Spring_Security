# Spring Security – User Authentication System (Spring Boot + JWT)

## 📌 Project Overview

This project is a **User Authentication System** built using **Spring Boot and Spring Security** with **JWT (JSON Web Token)** for stateless authentication.

It provides:

* Secure user registration
* Login with JWT token generation
* Role-based authorization
* Protected REST APIs

The application follows a **clean layered architecture** using **DTOs, mappers, service layer, and global exception handling**.

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Security
* JWT (JSON Web Token)
* Spring Data JPA (Hibernate)
* MySQL
* Maven
* Postman (API testing)

---

## ✨ Key Features

* User registration with role (**ADMIN / USER**)
* Secure login using JWT
* Password encryption using **BCrypt**
* Role-based access control
* DTO-based request and response handling
* Global exception handling
* Clean service and mapper layers
* Protected REST endpoints

---

## 📂 Project Structure

```
com.user
│
├── controller
│   └── UserController
│
├── service
│   ├── UserService
│   └── UserServiceImpl
│
├── repository
│   └── UserRepository
│
├── entity
│   ├── User
│   └── Role
│
├── dto
│   ├── ApiResponse
│   ├── AuthRequest
│   ├── AuthResponse
│   ├── UserRequest
│   └── UserResponse
│
├── exception
│   └── GlobalExceptionHandler
│
├── mapper
│   └── UserMapper
│
├── security
│   ├── JwtUtil
│   ├── JwtFilter
│   └── SecurityConfig
│
└── UserApplication
```

---

## 🗄️ Database Schema

### User Table

| Column   | Type   | Description        |
| -------- | ------ | ------------------ |
| id       | Long   | Primary key        |
| username | String | Unique username    |
| password | String | Encrypted password |
| role     | String | USER or ADMIN      |

---

## 🚀 API Endpoints

### 1. Register User

**POST** `/api/v1/users/register`

**Request**

```json
{
  "username": "admin",
  "password": "admin123",
  "role": "ADMIN"
}
```

**Response**

```json
{
  "message": "User registered successfully"
}
```

---

### 2. Login

**POST** `/api/v1/users/login`

**Request**

```json
{
  "username": "admin",
  "password": "admin123"
}
```

**Response**

```json
{
  "token": "JWT_TOKEN"
}
```

---

### 3. Get All Users (ADMIN only)

**GET** `/api/v1/users`

**Header**

```
Authorization: Bearer <JWT_TOKEN>
```

**Response**

```json
[
  {
    "id": 1,
    "username": "admin",
    "role": "ADMIN"
  }
]
```

---

## 🔐 Authentication Flow

1. User registers with username, password, and role.
2. Password is encrypted using **BCrypt**.
3. User logs in with credentials.
4. Server generates a **JWT token**.
5. Token is sent in the request header.
6. JWT filter validates the token.
7. Spring Security checks user role.
8. Access is granted or denied.

---

## ⚙️ How to Run the Project

### 1. Clone the Repository

```bash
git clone https://github.com/Rohinic1998/Spring_Security.git
```

### 2. Open in IDE

Open the project in **IntelliJ IDEA** or **Eclipse**.

---

### 3. Configure Database

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/user_jwt_db
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

### 4. Run the Application

Run:

```
UserApplication.java
```

Server starts at:

```
http://localhost:8080
```

---

## 🧪 Testing with Postman

### Register

```
POST http://localhost:8080/api/v1/users/register
```

### Login

```
POST http://localhost:8080/api/v1/users/login
```

### Access Secured API

Add header:

```
Authorization: Bearer <JWT_TOKEN>
```

---

## 📈 Future Enhancements

* Refresh token implementation
* Email verification for new users
* Password reset functionality

---

## 👩‍💻 Author

**Rohini Chavan**
Java Backend Developer
GitHub: https://github.com/Rohinic1998
