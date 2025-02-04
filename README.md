# Bagugatreino: A Fitness Workout Management API

Bagugatreino is a Spring Boot-based RESTful API designed for managing fitness workouts, exercises, and user profiles.

This application provides a comprehensive backend solution for fitness enthusiasts and trainers to create, manage, and track workouts and exercises. It offers secure user authentication, role-based access control, and detailed exercise and workout management capabilities.

## Repository Structure

The project follows a standard Spring Boot application structure:

```
.
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com.thiago.bagugatreino
│   │   │       ├── controller
│   │   │       ├── dto
│   │   │       ├── entity
│   │   │       ├── infra
│   │   │       ├── repository
│   │   │       └── service
│   │   └── resources
│   └── test
└── pom.xml
```

Key Files:
- `BagugatreinoApplication.java`: The main entry point for the Spring Boot application.
- `pom.xml`: Maven project configuration file.
- `application.properties`: Application configuration file.

Important integration points:
- `AuthenticationController.java`: Handles user authentication and registration.
- `ExerciseController.java`, `ExerciseSetController.java`, `WorkoutController.java`: Manage exercises, exercise sets, and workouts respectively.
- `SecurityConfigurations.java`: Configures Spring Security settings.
- `OpenApiConfig.java`: Configures Swagger/OpenAPI documentation.

## Usage Instructions

### Installation

Prerequisites:
- Java 11 or higher
- Maven 3.6 or higher
- MySQL 8.0 or higher

Steps:
1. Clone the repository:
   ```
   git clone https://github.com/your-username/bagugatreino.git
   cd bagugatreino
   ```
2. Configure the database connection in `src/main/resources/application.properties`.
3. Build the project:
   ```
   mvn clean install
   ```
4. Run the application:
   ```
   mvn spring-boot:run
   ```

### Getting Started

1. Register a new user:
   ```
   POST /auth/register
   {
     "email": "user@example.com",
     "password": "password123",
     "role": "USER",
     "name": "John Doe",
     "birthday": "1990-01-01",
     "gender": "MALE"
   }
   ```

2. Authenticate and obtain a JWT token:
   ```
   POST /auth/login
   {
     "email": "user@example.com",
     "password": "password123"
   }
   ```

3. Use the JWT token in the Authorization header for subsequent requests:
   ```
   Authorization: Bearer <your_jwt_token>
   ```

### Common Use Cases

1. Create a new workout:
   ```
   POST /workout
   {
     "userId": 1,
     "name": "Full Body Workout"
   }
   ```

2. Add an exercise to a workout:
   ```
   POST /workout/{workoutId}/exercise/{exerciseId}
   ```

3. Create an exercise set:
   ```
   POST /exerciseset
   {
     "repetitions": 12,
     "weight": 50.5,
     "exerciseId": 1,
     "workoutId": 1,
     "userId": 1
   }
   ```

4. Retrieve user's workouts:
   ```
   GET /workout/user/{userId}
   ```

### Testing & Quality

Run the tests using:
```
mvn test
```

### Troubleshooting

1. Issue: Unable to connect to the database
   - Ensure MySQL is running and accessible.
   - Check the database configuration in `application.properties`.
   - Verify network connectivity if using a remote database.

2. Issue: Authentication fails
   - Ensure the correct email and password are being used.
   - Check if the user is registered in the system.
   - Verify the JWT token is correctly included in the Authorization header.

To enable debug mode, add the following to `application.properties`:
```
logging.level.com.thiago.bagugatreino=DEBUG
```

Log files can be found in the `logs` directory in the project root.

## Data Flow

The request data flow in Bagugatreino follows a typical Spring MVC pattern:

1. Client sends a request to a specific endpoint.
2. The request is intercepted by the `SecurityFilter` which validates the JWT token if present.
3. If authenticated, the request is routed to the appropriate controller.
4. The controller processes the request, often delegating business logic to a service.
5. Services interact with repositories to perform CRUD operations on the database.
6. The response is constructed and sent back to the client.

```
Client -> SecurityFilter -> Controller -> Service -> Repository -> Database
       <-                <-            <-         <-            <-
```

Note: The `SecurityFilter` ensures that only authenticated users can access protected endpoints, and the `TokenService` handles JWT token generation and validation.

## Infrastructure

The application uses the following key infrastructure components:

- Spring Security (`SecurityConfigurations.java`):
  - Configures CORS, CSRF, session management, and authorization rules.
  - Sets up JWT-based authentication.

- Swagger/OpenAPI (`OpenApiConfig.java`):
  - Configures API documentation with JWT authentication support.

- JWT Token Service (`TokenService.java`):
  - Handles generation and validation of JWT tokens for user authentication.

These components work together to provide a secure, well-documented API for the Bagugatreino application.