# User Registration and Fetch API

This Spring Boot application provides RESTful API endpoints for user registration and fetching user details. It uses an in-memory storage mechanism for simplicity.

## Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Technologies Used](#technologies-used)
- [Setup and Installation](#setup-and-installation)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Accessing H2 Database Console](#accessing-h2-database-console)
- [Project Structure](#project-structure)
- [Future Improvements](#future-improvements)
- [Author](#author)


## Features

1. **User Registration Endpoint** (`POST /api/user/register`):
    - Registers a new user with username, email, and password.
    - Passwords are securely hashed using BCrypt before storing.
    - Handles duplicate username registration.


2. **User Fetch Endpoint** (`GET /api/user/fetch`):
    - Fetches user details based on username query parameter.
    - Throws `UserNotFoundException` if the user is not registered.


3. **Exception Handling**:
    - Global exception handling for consistent error responses.
    - Specific exceptions (`RuntimeException` for general errors, `UserNotFoundException` for user-specific errors).


4. **Security**:
    - Passwords are securely hashed using BCrypt.
    - In-memory storage for demonstration purposes; can be extended to use a database for persistent storage.


5. **Documentation**:
    - Uses Springdoc OpenAPI for API documentation.
    - Includes Curl commands for API consumption in README.

## Requirements

- Java 17
- Maven

## Technologies Used

- **Spring Boot** - For building the RESTful API.
- **Spring Data JPA** - For data access and management.
- **H2 Database** - In-memory database for storing user details.
- **Spring Security** - For password hashing (`BCryptPasswordEncoder`).
- **Springdoc OpenAPI** - For API documentation.


## Setup and Installation

1. **Clone the repository**:

   ```bash
   git clone https://github.com/regmi-keshav/UserRegistrationEndpoint.git
   cd UserRegistrationEndpoint
   
2. **Build the project:**
   If using Maven:
    ```bash
    ./mvnw clean install

## Running the Application

You can run the application using your IDE or from the command line.

**Using the Command Line:**

```sh
./mvnw spring-boot:run
```
#### The application will start and be accessible at `http://localhost:8080`

After starting the application:

- Access the Swagger UI for API documentation: `http://localhost:8080/swagger-ui/index.html`
- Use tools like Postman or Curl to interact with the API endpoints.

## API Endpoints

 1. **User Registration** : Registers a new user with the following JSON request body

     - URL: `POST/api/user/register`
        ```bash
       {
          "username": "john_doe",
          "email": "john@example.com",
          "password": "password123"
       }
        ```
    - Responses :
       * `200 OK` if the user is registered successfully
       * `400 Bad` Request if the user already exists or other validation errors


 2. **Fetch User Details**:
    Fetches user details based on the username query parameter.

     - URL: `GET/api/user/fetch?username={username}`
    
    - Responses:
       *  `200 OK` with user details if found    
       * `400 Bad Request` if the user is not found

## Example Curl Commands
1. **Register User:**

    ```sh
    curl -X POST http://localhost:8080/api/user/register \
     -H "Content-Type: application/json" \
     -d '{
           "username": "john_doe",
           "email": "john@example.com",
           "password": "password123"
         }'

2. **Fetch User Details:**

    ```bash 
   curl -X GET "http://localhost:8080/api/user/fetch?username=john_doe"
    ```
## Accessing H2 Database Console
The H2 database console is available for viewing the in-memory database.

- URL: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:testdb` 
- User Name: `sa` 
- Password: `password`

## Project Structure
The project structure follows:
- `src/main/java/com/example/UserRegistrationEndpoint`
  - `UserRegistrationEndpointApplication.java`: Main application class.
  - `config` : Contains the Configuration for Swagger UI
  - `controller`: Contains the REST controllers.
  - `model`: Contains the User model.
  - `service`: Contains the service classes.
  - `security`: Contains security-related configurations.
  - `exception`: Contains custom exception classes and global exception handler.

## Future Improvements
- Implement database integration (e.g., MySQL, PostgreSQL) for persistent storage.
- Enhance security features (e.g., JWT authentication). 
- Implement API versioning. 
- Improve error handling and validation. 
- Add more comprehensive unit and integration tests.


## Author
- `Keshav Regmi`
- GitHub: `https://github.com/regmi-keshav`