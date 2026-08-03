# Modamart Backend

[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.3-brightgreen)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.x-orange)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)

A Spring Boot backend for the Modamart e-commerce application. This project provides REST APIs for user registration/login, product catalog management, cart operations, and likes.

## Features

- User signup and login
- Product CRUD APIs for Men, Women, Kids, Unisex, and Accessories
- Cart management endpoints
- Like/unlike product functionality
- MySQL persistence with Spring Data JPA
- Basic security and CORS configuration

## Tech Stack

- Java 17
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- Spring Security
- MySQL
- Maven
- Lombok
- JWT libraries

## Installation

### Prerequisites
- Java 17+
- Maven
- MySQL Server

### Backend Setup
1. Clone the repository
2. Create a MySQL database named `modamart`
3. Update the database credentials in `src/main/resources/application.properties`
4. Run:

```bash
./mvnw spring-boot:run
```

## Folder Structure

```text
src/
  main/
    java/com/modamart/
      config/
      controller/
      dto/
      entity/
      repository/
      security/
      service/
    resources/
      application.properties
      application-prod.properties
```

## API Overview

### Authentication
- `POST /api/auth/signup`
- `POST /api/auth/login`

### Products
- `GET /api/men`
- `GET /api/women`
- `GET /api/kids`
- `GET /api/unisex`
- `GET /api/accessories`

### Cart
- `POST /api/cart/add`
- `GET /api/cart/{userId}`
- `PUT /api/cart/update`
- `DELETE /api/cart/remove/{id}`
- `DELETE /api/cart/clear/{userId}`

### Likes
- `POST /api/likes`
- `GET /api/likes/{userId}`
- `DELETE /api/likes/{userId}`

## Screenshots

Add screenshots here for:
- Authentication flow
- Product catalog
- Cart management
- Like functionality

## Future Improvements

- Add frontend UI
- Implement role-based admin access
- Add order and checkout flow
- Improve API security and validation
- Add Swagger/OpenAPI documentation

## License

This project is licensed under the MIT License.

## Author

Modamart Backend Project
