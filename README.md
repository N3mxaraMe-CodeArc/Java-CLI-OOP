# OOP Ticketing System

## Overview
The OOP Ticketing System is a Java-based application designed for managing tickets, users, and related operations in an object-oriented manner. It is built following industry standards and utilizes multiple layers to ensure modularity, scalability, and maintainability. The system is structured using core OOP principles and employs common design patterns.

### Features
- **Ticket Management:** Efficient creation, updating, and tracking of tickets.
- **User Management:** User roles and authentication to control access.
- **Advanced Configuration:** Configurable options for system behavior.
- **Error Handling:** Custom exception handling for better debugging and system reliability.
- **Scalable Architecture:** Designed to scale with growing ticketing requirements.

## Project Structure
The project is structured into multiple modules for separation of concerns, making the application more maintainable and scalable. Below is a breakdown of the key components of the project:

### Root Structure
Root Structure

### Modules Breakdown
- **Configurations:** Includes system configuration files, such as application settings, environment configurations, and external integrations.
- **Controllers:** Implements the controllers responsible for managing user inputs and directing them to the appropriate services and views.
- **Dto (Data Transfer Objects):** Contains objects that represent the data structures used for communication between layers of the application (e.g., between controller and service).
- **Entity:** Contains the core domain models of the system, such as Ticket, User, Priority, and Status. These models represent the main data objects in the system.
- **Repo:** Responsible for interacting with the database, providing methods to query, insert, update, and delete entities.
- **Service:** Contains business logic that processes data, communicates between layers, and ensures that application rules are enforced.

## Main Application
- **OopTicketingSystemApplication.java:** This is the entry point of the application. It initializes the system and starts the ticketing process.

## Requirements
- **JDK 8+:** Java Development Kit, version 8 or higher.
- **Maven:** For dependency management and building the project.
- **MySQL/PostgreSQL:** A relational database for storing ticketing data (configuration files for database setup are included).

## Setup and Installation
Follow these steps to set up and run the application locally:

### Prerequisites
1. **Install Java 8 or higher:**
   - You can download and install the JDK from the [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html).
   
2. **Install Maven:**
   - Maven is used for building and managing dependencies. Download and install it from [Apache Maven](https://maven.apache.org/).

3. **Install Database:**
   - This system can be configured to work with either MySQL or PostgreSQL. Install one of these databases and set it up for the project.

### Steps to Run
1. Clone the repository:
    ```
    git clone https://github.com/N3mxaraMe-CodeArc/TicketingSystemOOP/tree/dev-server
    ```

2. Configure Database:
    - Edit the configuration file (located in `/src/main/resources/application.properties`) to provide the correct database credentials.

### Configuration Files
The configuration files for the system can be found in the `/src/main/resources` directory:
- **application.properties** – contains database configurations and other environment-related settings.

## API Documentation
If your project has a REST API or other forms of communication (like GraphQL), provide the details here. For example:
- **POST /api/tickets:** Create a new ticket.
- **GET /api/tickets/{id}:** Retrieve a ticket by its ID.

Provide all the available endpoints and any required parameters.

## Contributing
We welcome contributions to this project. If you'd like to contribute, please follow these steps:
1. Fork the repository.
2. Create a new branch for your changes.
3. Make your modifications.
4. Commit your changes with clear, descriptive messages.
5. Push your branch and create a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for more information.

## Acknowledgements
Thanks to all contributors for improving this system. Special thanks to the open-source community for the libraries and tools that made this project possible.
