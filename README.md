# Teleport Project

This project is the backend service for **Teleport**, implemented using Java and the **Spring Boot** framework. It follows a clean, multi-layered architecture to ensure scalability, maintainability, and ease of expansion.

## Project Structure

The **Teleport** backend service is structured in a layered architecture with the following main layers:

1. **Controller Layer**: Handles incoming HTTP requests and routes them to the appropriate services.
2. **Service Layer**: Contains the core business logic, coordinating between controllers and the data access layer.
3. **Repository Layer**: Provides an interface to interact with the database using **Spring Data JPA**.

### Additional Components

- **JWT Authentication**: Uses **JSON Web Tokens (JWT)** for secure user authentication and authorization.
- **DTOs**: Data Transfer Objects ensure safe and organized data flow between application layers.
- **Configurations**: Settings, especially for external connections and security, are maintained here.
- **Exception Handling**: Provides robust error handling with custom responses for user-friendly feedback.

## Features

- **User Management**: Supports user sign-up and sign-in functionality.
- **Database Integration**: The backend connects to a **MySQL** database to persist user and other application data.
- **Environment Configuration**: Database connection details, such as URLs and credentials, are managed using environmental variables, enhancing deployment flexibility.

## Getting Started

### Prerequisites

- **Java** (version 11 or later)
- **Maven** for dependency management
- **MySQL** for data persistence

### Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/kheder-hassoun/TelePort-Back-End-.git
   cd teleport-backend
   ```

2. **Database Setup**:
   - Create a MySQL database named `teleport_db`.
   - Update the database configurations in `application.yml` or as environment variables.

3. **Install Dependencies**:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   ```bash
   mvn spring-boot:run
   ```

### Endpoints Overview

- **AuthenticationController**:
  - `/auth/signin` - Authenticates a user and returns an access token.
  - `/auth/signup` - Registers a new user in the system.

## Architecture

The application adheres to **Clean Architecture** principles, ensuring separation of concerns and promoting flexibility. The following structure is maintained:

- **Entity Layer**: Represents database entities.
- **Repositories**: Interfaces for database CRUD operations.
- **Services**: Business logic to ensure valid processing of requests.
- **Controllers**: Handle web requests and route them to respective services.

## Security

**JWT** is used for secure communication, allowing the backend to validate user sessions and secure sensitive data.

## Contributing

1. Fork the repository
2. Create a new branch for your feature:
   ```bash
   git checkout -b feature/YourFeature
   ```
3. Commit your changes and open a pull request.
