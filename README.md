# Project - Airline

## Project Description

The project aims to develop a management system for an airline using Spring with Spring Boot and Spring Security. This system will allow the comprehensive management of users, flights, reservations and destinations, with advanced features such as secure authentication using Basic Auth or JWT. The system cannot allow the selection of flights without available seats or that have passed the deadline. The project will be implemented using Java 21, Maven and MySQL or PostgreSQL.


## Technical Requirements
- Java programming knowledge.
- Knowledge of Object Oriented Programming (OOP).
- Spring, Spring Boot and Spring Security
- Basic authentication and JWT
- Testing
- Docker
- DB knowledge (relationships, data preloading, etc.)

## Project Timeline

- **3-week sprint**.

## Performance Criteria

- The **backend architecture layers** should be well-defined.
- The **database tables** should be **normalized**.
- **Unit tests** should cover the main functionalities of the system.

---

## Project Structure

This project is organized using **Spring Boot** to create a REST API. Below are the main layers of the system:

- **Controllers**: Handle HTTP requests and delegate business logic to services.
- **Services**: Contain business logic and handle interactions with models.
- **Models**: Represent the system's data, including entities for necessary objects.
- **Repositories**: Manage data persistence through JPA.
- **DTOs**: Define data structures for transferring information.

## Installation

### Prerequisites:
- **Java 21**
- **Maven** to manage dependencies.

### Steps to run the project:

1. **Clone the repository**:

    ```bash
    git clone https://github.com/abdiaslabrador/java_airline_ff5
    cd java_airline_ff5
    ```

2. **Configure the database**:
    Since we're using the in-memory H2 database, no additional configuration is needed here.

3. **Build and run the project**:

    ```bash
    mvn clean install
    mvn spring-boot:run
    ```

4. **Access the API**:
    - The API will be available at `http://localhost:8080/api/v1/`.
    - You can use tools like **Postman** or **Insomnia** to test the endpoints.

---

## API Endpoints

### 1. **Administrator Management**
#### Airports
- **GET /api/v1/airports**: get airport list.
- **POST /api/v1/airports**:  save airport.
- **PUT /api/v1/airports/{id}**: update airport.
- **DELETE /api/v1/airports/{id}**: delete airport.
- **POST /api/v1/auth/token**: user login.


#### Flights
- **POST /api/v1/flights**: Create a new flight.
- **GET /api/v1/flights**: Get the flight list.
- **PUT /api/v1/flights/{id}**: Update an flight.
- **DELETE /api/v1/flights/{id}**: Delete an flight.
- **GET /api/v1/flights/search**: get flight list that connects whit the html query params (String originCodeAirport, String destinationCodeAirport, LocalDateTime timestamp, int seats)

#### Reservations
- **Get  /api/v1/reservations/admin/client/{username}**: Get the reservations of a epecific client.

### 2. **Client side**                                           
- **Get  /api/v1/reservations/client/**: Get the client reservations.

### 3. **All public**
- **POST /api/v1/register**: Create a new user.

## Testing

The project uses **JUnit 5** for unit tests.

### Running Tests

To run the tests, use the following Maven command:

    mvn test


## Diagrams
Include diagrams such as:
- **Class Diagram**:

<img src="screenshot/relational_diagram.png" alt="Relational Diagram" width="40%">


## Authors
### Contact us with:

**Abdias Labrador** [GitHub](https://github.com/abdiaslabrador) / [LinkedIn](https://www.linkedin.com/in/abdias-labrador/)

