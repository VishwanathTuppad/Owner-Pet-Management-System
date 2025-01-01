# Owner-Pet Management Application
The Owner-Pet Management Application is a robust and modular Spring Boot project designed to manage owner and pet data effectively. It provides functionalities to create, retrieve, update, and delete (CRUD) records for owners and their pets.

The project leverages Hibernate as the ORM (Object-Relational Mapping) framework for seamless interaction with the database, ensuring efficient data persistence and retrieval operations.

This application follows a well-structured, layered architecture and adheres to coding standards for clean and maintainable code.

## Key Features
+ **Owner Management:** Add, update, delete, and retrieve owner details.
+ **Pet Management:** Manage pet details and associate pets with owners.
+ **REST API Design:** Exposes well-defined endpoints for CRUD operations.
+ **Validation:** Input validation using Spring Validator and custom annotations.
+ **Exception Handling:** Comprehensive exception handling with meaningful error messages.
+ **Scalability:** Modular and layered architecture for future extensibility.
+ **Swagger API Documentation:** Interactive API documentation for easier integration.

## API Endpoints
### Owner Endpoints
+ **POST /api/owners:** Adds a new owner to the system. </br>
+ **GET /api/owners/{ownerId}:** Retrieve owner details by ID. </br>
+ **PUT /api/owners/{ownerId}/pets:** Update owner details. </br>
+ **DELETE /api/owners/{ownerId}:** Delete owner.

### Pet Endpoints
+ **GET /api/pets/{petId}:** Fetches details of a pet by its unique ID.

### Technologies Used
+ **Language:** Java 17
+ **Framework:** Spring Boot 3.x
+ **Database:** MySQL (or mention your database)
+ **Build Tool:** Maven
+ **Tools:** IntelliJ IDEA, Postman, Git
