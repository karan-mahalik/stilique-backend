# Modamart Backend Documentation Report

> This report is based strictly on the source files and configuration present in this repository. Where functionality is not implemented, it is marked as “Not Found in Project”.

---

## 1. Project Overview

### Project Name
- modamart-backend

### Purpose
- This repository contains a Spring Boot backend for an e-commerce-style application named Modamart.
- The implemented backend exposes REST APIs for user authentication, product catalog management, cart handling, and likes.

### Problem Statement
- Not explicitly documented in the project.
- From the codebase, the implemented scope is to provide backend services for:
  - user registration and login
  - managing product records across categories
  - adding and updating cart items
  - liking products

### Target Users
- End users of the ecommerce application
- Developers/maintainers working on the backend service

### Main Functionalities
- User signup and login
- Product CRUD operations for Men, Women, Kids, Unisex, and Accessories
- Cart creation and item management
- Product liking functionality
- Basic CORS and security configuration

---

## 2. Tech Stack

### Frontend
- Not Found in Project

### Backend
- Java 17
- Spring Boot 3.5.3
- Spring Web
- Spring Data JPA
- Spring Security
- Hibernate/JPA

### Database
- MySQL
- JDBC driver: MySQL Connector/J

### Authentication
- BCrypt password hashing
- JWT utility classes are present (`JwtUtil`, `JwtAuthFilter`)
- JWT is not currently wired into endpoint authorization flow in the implemented code

### Build Tools
- Maven
- Maven Wrapper (`mvnw` / `mvnw.cmd`)

### Libraries
- Lombok
- JJWT (`jjwt-api`, `jjwt-impl`, `jjwt-jackson`)
- Spring Boot Test
- Spring Security Test

### Frameworks
- Spring Boot
- Spring Security
- Spring Data JPA

### APIs
- RESTful HTTP APIs

### Dependencies
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-security`
- `spring-boot-starter-web`
- `mysql-connector-j`
- `lombok`
- `jjwt-*`
- `spring-boot-starter-test`
- `spring-security-test`

---

## 3. Architecture

### Frontend Flow
- Not Found in Project
- There is no frontend source code in the repository to analyze.

### Backend Flow
- The application is organized in a layered Spring Boot structure:
  - Controllers receive HTTP requests
  - Services contain business logic
  - Repositories perform database access via JPA
  - Entities map to MySQL tables
  - DTOs are used as request/response payload containers

### Request Lifecycle
1. A client sends an HTTP request to a controller endpoint.
2. The controller receives the request and delegates to a service or repository.
3. The repository uses Spring Data JPA to interact with the MySQL database.
4. The response is returned as a JSON object or entity list.

### Database Communication
- The project uses Spring Data JPA with MySQL.
- Database configuration is defined in `application.properties` and `application-prod.properties`.
- Entities are persisted using Hibernate with `ddl-auto=update`.

### Authentication Flow
- User registration hashes the password with BCrypt.
- Login checks the submitted password against the stored hashed password.
- JWT classes are present but are not used to issue and validate tokens through the current login endpoint.
- Spring Security is configured to permit all requests by default.

---

## 4. Folder Structure

```text
modamart-backend/
├── .github/
├── .mvn/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── modamart/
│   │   │           ├── config/
│   │   │           ├── controller/
│   │   │           ├── dto/
│   │   │           ├── entity/
│   │   │           ├── repository/
│   │   │           ├── security/
│   │   │           └── service/
│   │   └── resources/
│   │       ├── application.properties
│   │       └── application-prod.properties
│   └── test/
│       └── java/
│           └── com/
│               └── modamart/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── target/
```

### Major Folders
- `config/` – Spring configuration classes such as CORS and security setup
- `controller/` – REST controllers for the API endpoints
- `dto/` – Data transfer objects for request/response payloads
- `entity/` – JPA entity classes mapped to tables
- `repository/` – Spring Data repositories for persistence
- `security/` – JWT utility and filter classes
- `service/` – Business logic for cart and liked products
- `resources/` – Application properties files
- `test/` – Basic Spring Boot test classes

---

## 5. Features

### User Features
- Register a new user
- Log in with email and password
- View product listings by category
- Add products to cart
- Update cart item quantity/metadata
- Remove items from cart
- Clear the cart for a user
- Like a product
- View products liked by a user

### Admin Features
- Not Found in Project
- There are no role-based admin endpoints or admin-only access controls in the code.

### Backend Features
- CRUD operations for categories and products
- JPA-based persistence to MySQL
- CORS handling for frontend access
- JWT utility support
- Basic repository-based data access

### Security Features
- Password hashing with BCrypt
- Unique email constraint for users
- CSRF disabled in security configuration
- CORS configuration for `http://localhost:5173`

---

## 6. Database

### Tables / Entities

#### 1. `users`
- Purpose: Stores user account information.
- Fields:
  - `id` (Long, auto-generated)
  - `email` (String, unique)
  - `password` (String)
  - `fullName` (String)
- Relationships:
  - No explicit JPA relationship mapping exists.
  - The cart and likes entities reference `userId` as a simple field.

#### 2. `cart_items`
- Purpose: Stores products added to a user’s shopping cart.
- Fields:
  - `id`
  - `userId`
  - `productId`
  - `title`
  - `image`
  - `quantity`
  - `price`
- Relationships:
  - No explicit relationship mapping to `users` or product entities.

#### 3. `likes`
- Purpose: Stores products liked by users.
- Fields:
  - `id`
  - `userId`
  - `productId`
- Constraints:
  - Unique constraint on `(userId, productId)`
- Relationships:
  - No explicit JPA relationship mapping.

#### 4. `men_products`
- Purpose: Stores Men category products.
- Fields:
  - `id`
  - `title`
  - `category`
  - `subCategory`
  - `price`
  - `size`
  - `color`
  - `pattern`
  - `occasion`
  - `embellishment`
  - `imageName`

#### 5. `women_products`
- Purpose: Stores Women category products.
- Same field set as `men_products`.

#### 6. `kids_products`
- Purpose: Stores Kids category products.
- Same field set as `men_products`.

#### 7. `unisex_products`
- Purpose: Stores Unisex category products.
- Same field set as `men_products`.

#### 8. `accessories`
- Purpose: Stores accessory products.
- Fields:
  - `id`
  - `name`
  - `image`
  - `price`
  - `category`
  - `type`
  - `color`
  - `size`
  - `description`

### ER Relationship Explanation
- The codebase does not define explicit relational mappings using `@ManyToOne`, `@OneToMany`, or `@OneToOne`.
- Relationships are represented conceptually by fields such as `userId` and `productId` rather than formal JPA associations.
- Therefore, the project currently uses a simple table-based design with logical references rather than a fully normalized relational model.

---

## 7. REST APIs

### Authentication Endpoints

| URL | Method | Request Body | Response | Auth Required | Description |
|---|---|---|---|---|---|
| `/api/auth/signup` | POST | `{ email, password, fullName }` | JSON message with email | No | Registers a new user |
| `/api/auth/login` | POST | `{ email, password }` | JSON message and email | No | Authenticates a user |

### Men Products

| URL | Method | Request Body | Response | Auth Required | Description |
|---|---|---|---|---|---|
| `/api/men` | POST | `Men` object | Created `Men` entity | No | Add a single product |
| `/api/men/bulk` | POST | List of `Men` objects | List of `Men` entities | No | Add multiple products |
| `/api/men` | GET | None | List of `Men` entities | No | Get all men products |
| `/api/men/{id}` | GET | None | `Men` entity or empty | No | Get one men product |
| `/api/men/{id}` | PUT | `Men` object | Updated `Men` entity | No | Update a men product |
| `/api/men/{id}` | DELETE | None | Empty response | No | Delete a men product |

### Women Products

| URL | Method | Request Body | Response | Auth Required | Description |
|---|---|---|---|---|---|
| `/api/women` | POST | `Women` object | Created `Women` entity | No | Add a single product |
| `/api/women/bulk` | POST | List of `Women` objects | List of `Women` entities | No | Add multiple products |
| `/api/women` | GET | None | List of `Women` entities | No | Get all women products |
| `/api/women/{id}` | GET | None | `Women` entity or empty | No | Get one women product |
| `/api/women/{id}` | PUT | `Women` object | Updated `Women` entity | No | Update a women product |
| `/api/women/{id}` | DELETE | None | Empty response | No | Delete a women product |

### Kids Products

| URL | Method | Request Body | Response | Auth Required | Description |
|---|---|---|---|---|---|
| `/api/kids` | POST | `Kids` object | Created `Kids` entity | No | Add a single product |
| `/api/kids/bulk` | POST | List of `Kids` objects | List of `Kids` entities | No | Add multiple products |
| `/api/kids` | GET | None | List of `Kids` entities | No | Get all kids products |
| `/api/kids/{id}` | GET | None | `Kids` entity or empty | No | Get one kids product |
| `/api/kids/{id}` | PUT | `Kids` object | Updated `Kids` entity | No | Update a kids product |
| `/api/kids/{id}` | DELETE | None | Empty response | No | Delete a kids product |

### Unisex Products

| URL | Method | Request Body | Response | Auth Required | Description |
|---|---|---|---|---|---|
| `/api/unisex` | POST | `Unisex` object | Created `Unisex` entity | No | Add a single product |
| `/api/unisex/bulk` | POST | List of `Unisex` objects | List of `Unisex` entities | No | Add multiple products |
| `/api/unisex` | GET | None | List of `Unisex` entities | No | Get all unisex products |
| `/api/unisex/{id}` | GET | None | `Unisex` entity or empty | No | Get one unisex product |
| `/api/unisex/{id}` | PUT | `Unisex` object | Updated `Unisex` entity | No | Update a unisex product |
| `/api/unisex/{id}` | DELETE | None | Empty response | No | Delete a unisex product |

### Accessories

| URL | Method | Request Body | Response | Auth Required | Description |
|---|---|---|---|---|---|
| `/api/accessories` | POST | `Accessories` object | Created `Accessories` entity | No | Add a single accessory |
| `/api/accessories` | GET | None | List of `Accessories` entities | No | Get all accessories |
| `/api/accessories/{id}` | GET | None | `Accessories` entity or empty | No | Get one accessory |
| `/api/accessories/{id}` | PUT | `Accessories` object | Updated `Accessories` entity | No | Update an accessory |
| `/api/accessories/{id}` | DELETE | None | Empty response | No | Delete an accessory |

### Cart

| URL | Method | Request Body | Response | Auth Required | Description |
|---|---|---|---|---|---|
| `/api/cart/add` | POST | `CartItem` object | Created `CartItem` | No | Add item to cart |
| `/api/cart/{userId}` | GET | None | List of `CartItem` entities | No | Get cart items by user |
| `/api/cart/remove/{id}` | DELETE | None | Empty response | No | Remove one cart item |
| `/api/cart/clear/{userId}` | DELETE | None | Empty response | No | Clear all items for a user |
| `/api/cart/update` | PUT | `CartItem` object | Updated `CartItem` | No | Update cart item |

### Likes

| URL | Method | Request Body | Response | Auth Required | Description |
|---|---|---|---|---|---|
| `/api/likes` | POST | `{ userId, productId }` | Created `Like` entity | No | Like a product |
| `/api/likes/{userId}` | DELETE | None | String message | No | Unlike all products for a user |
| `/api/likes/{userId}` | GET | None | List of `Like` entities | No | Get liked products for a user |

---

## 8. Authentication

### Login Process
- The login endpoint accepts an email and password.
- It looks up the user by email.
- It verifies the password with BCrypt.
- If validation succeeds, it returns a success message and the email.

### Registration
- The signup endpoint accepts `email`, `password`, and `fullName`.
- It checks whether the email already exists.
- It hashes the password with BCrypt and stores the user.

### JWT
- JWT utility classes exist in `security/JwtUtil.java` and `security/JwtAuthFilter.java`.
- These classes can generate, validate, and extract JWT claims.
- However, the current endpoints do not issue JWTs in the login response and do not enforce JWT-based authorization.

### Spring Security
- Spring Security is included and configured through `SecurityConfig`.
- CSRF is disabled.
- All requests are currently permitted without authentication.

### Password Encryption
- Passwords are encoded using `BCryptPasswordEncoder`.

### Authorization
- Not implemented in the current project.
- There are no role-based permissions, protected routes, or admin-only access checks.

---

## 9. Frontend

### Routing
- Not Found in Project

### Components
- Not Found in Project

### Pages
- Not Found in Project

### State Management
- Not Found in Project

### API Integration
- Not Found in Project

### Styling
- Not Found in Project

---

## 10. Backend

### Controllers
- `AuthController` – handles signup and login
- `MenController` – CRUD for men products
- `WomenController` – CRUD for women products
- `KidsController` – CRUD for kids products
- `UnisexController` – CRUD for unisex products
- `AccessoriesController` – CRUD for accessories
- `CartItemController` – cart operations
- `LikeController` – like/unlike/list operations

### Services
- `CartItemService` – add, fetch, delete, update cart items
- `LikeService` – like, unlike, list likes
- `UserService` – user persistence, password encoding, user lookup, update/delete

### Repository Layer
- Spring Data JPA repositories are implemented for each entity.
- Custom query methods include:
  - `findByEmail`
  - `findByUserId`
  - `findByUserIdAndProductId`
  - `deleteByUserId`

### DTOs
- `LoginRequest`
- `LoginResponse`
- `SignupRequest`

### Exception Handling
- Not implemented explicitly in the controllers.
- Errors are handled by Spring’s default behavior and simple `ResponseEntity` messages in authentication endpoints.

### Validation
- Not implemented in the project.
- There are no Bean Validation annotations such as `@NotNull`, `@Email`, or `@Size` in the entities or DTOs.

---

## 11. Security

Implemented security mechanisms include:
- BCrypt password hashing
- Spring Security dependency and configuration
- CORS configuration for `http://localhost:5173`
- Unique email constraint on users
- JWT helper classes

Security gaps observed:
- CSRF is disabled
- All requests are permitted without authentication
- JWT utility is not connected to the API authorization flow
- No role-based authorization
- Secret key is hardcoded in `JwtUtil`
- Database credentials are hardcoded in `application.properties`

---

## 12. Project Workflow

### User Registers
1. Client calls `POST /api/auth/signup`.
2. Controller checks if user exists by email.
3. If not, a new `User` is created.
4. Password is encoded with BCrypt.
5. User is saved to the database.

### User Logs In
1. Client calls `POST /api/auth/login`.
2. The user is fetched by email.
3. The submitted password is compared with the stored hash.
4. Success or failure message is returned.

### Product is Loaded
1. Client calls `GET /api/men`, `/api/women`, `/api/kids`, `/api/unisex`, or `/api/accessories`.
2. The controller calls the repository.
3. The repository returns a list of entity objects from the database.

### Product is Added
1. Client calls `POST` on a product category endpoint.
2. The controller receives the request body.
3. The repository saves the entity to the database.

### Cart is Updated
1. Client calls `POST /api/cart/add`, `PUT /api/cart/update`, `DELETE /api/cart/remove/{id}`, or `DELETE /api/cart/clear/{userId}`.
2. The service calls the cart repository.
3. Changes are saved or removed in the database.

### Order is Placed
- Not implemented in the project.
- There is no order entity, order service, or checkout flow in the repository.

---

## 13. Installation Guide

### Prerequisites
- Java 17+
- Maven or Maven Wrapper
- MySQL Server
- An IDE such as IntelliJ IDEA or VS Code

### Backend Setup
1. Clone the repository.
2. Create a MySQL database named `modamart`.
3. Update database credentials in `src/main/resources/application.properties`.
4. Run the project:

```bash
./mvnw spring-boot:run
```

### Frontend Setup
- Not Found in Project
- No frontend setup steps can be documented from the repository.

### Database Setup
- Create the database manually in MySQL.
- The project uses Hibernate `ddl-auto=update`, so tables are created automatically on startup.

### Environment Variables
- The production properties file uses placeholders such as:
  - `DB_HOST`
  - `DB_PORT`
  - `DB_NAME`
  - `DB_USER`
  - `DB_PASSWORD`
  - `PORT`

### Run Commands
```bash
./mvnw test
./mvnw spring-boot:run
```

---

## 14. Screenshots Needed

Suggested screenshots for the README:
- Homepage or category listing (if a frontend is added later)
- Login/register screen
- Cart page
- Like/favorite interaction flow
- Postman or cURL example for API calls
- MySQL table structure or database schema
- Project architecture diagram

---

## 15. Resume Highlights

- Built a Spring Boot backend for an e-commerce application with REST APIs.
- Implemented CRUD APIs for men, women, kids, unisex, and accessory products.
- Added user authentication with BCrypt password hashing.
- Integrated MySQL persistence using Spring Data JPA.
- Implemented cart and likes features for user interaction.
- Configured Spring Security and CORS for API access.
- Used JWT-related classes for future-secure authentication flows.
- Structured the backend with controllers, services, repositories, DTOs, and entities.
- Added Maven-based build and test setup for Java backend development.

---

## 16. GitHub README

A professional GitHub-ready README has been prepared in the repository root as `README.md`.

---

## 17. Code Quality Review

### Bugs
- Test run fails due to a bean name conflict between two security config classes:
  - `src/main/java/com/modamart/config/SecurityConfig.java`
  - `src/test/java/com/modamart/config/SecurityConfig.java`

### Code Smells
- Mixed commented-out legacy code remains in `AuthController` and `UserService`.
- Manual object creation and direct repository access are used instead of a cleaner service abstraction in some controllers.
- Repeated code across product controllers.
- Lombok is used inconsistently alongside manual getters/setters.

### Security Issues
- Hardcoded database credentials in `application.properties`
- Hardcoded JWT secret in `JwtUtil`
- No authorization rules; all routes are permitted
- No input validation
- No rate limiting or protection against abuse

### Performance Issues
- No pagination for product listing endpoints
- No indexing strategy details are defined in the code
- `findAll()` operations on large datasets may become inefficient

### Best Practice Violations
- Security configuration is permissive and not production-ready
- DTOs are not fully used for all CRUD paths
- No explicit exception handling strategy
- No API documentation tooling present

### Improvement Suggestions
- Remove duplicate security config test class conflict
- Introduce role-based authorization
- Use environment variables for all secrets and database settings
- Add validation annotations and proper error handling
- Add pagination and sorting for product endpoints
- Introduce an order module and checkout flow
- Add API documentation (Swagger/OpenAPI)
- Expand tests beyond basic context loading

---

## 18. Deployment Guide

### Frontend on Vercel
- Not applicable for the current repository because no frontend code is present.
- If a frontend is added later, it can be deployed on Vercel as a standard React/Vite/Next.js app.

### Backend on Render
1. Create a new Web Service on Render.
2. Choose the Java environment.
3. Connect the GitHub repository.
4. Set build command:

```bash
./mvnw clean package
```

5. Set start command:

```bash
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

6. Add environment variables for `DB_HOST`, `DB_PORT`, `DB_NAME`, `DB_USER`, `DB_PASSWORD`, and `PORT`.

### Database on Railway or Other Managed MySQL Service
1. Create a managed MySQL instance.
2. Copy the host, port, database name, username, and password.
3. Update the application configuration to use those values.
4. Ensure the backend can reach the database over the network.

---

## 19. Missing Features

Features that would improve the project for recruiters and real-world use:
- User roles and admin dashboard
- Product search and filtering
- Pagination and sorting
- Order placement and checkout
- Payment integration
- Email verification and password reset
- Image upload for products
- API documentation with Swagger/OpenAPI
- Unit and integration tests beyond context loading
- Docker support

---

## 20. Overall Evaluation

| Area | Score / 10 | Notes |
|---|---:|---|
| Backend | 7/10 | Functional REST API structure with CRUD and persistence |
| Frontend | 2/10 | No frontend code found in the repository |
| Architecture | 6/10 | Clear layering, but relationships and authorization are limited |
| Code Quality | 5/10 | Some duplication and security issues need attention |
| Portfolio Value | 7/10 | Good foundation for an e-commerce backend project |
| Resume Value | 7/10 | Strong for demonstrating Java/Spring Boot API development |

---

## Summary

This repository is a Spring Boot backend for an e-commerce application with product catalog, cart, likes, and basic authentication features. It shows solid backend fundamentals and a good starting point for further development, but it still needs security hardening, better architecture, and a frontend or full order workflow to become a complete production-style project.
