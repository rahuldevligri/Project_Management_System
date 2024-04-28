# Project-Management-System

Description:

This project implements a RESTful API for managing projects using Java 17 and Spring Boot. It provides CRUD operations, error handling, and data validation.

Features:

Create, Read, Update, and Delete projects
In-memory H2 database
Global exception handling
Spring validation for data input
Unit and integration tests
Swagger documentation for API endpoints
Setup Instructions:

Clone the repository: git clone <repository_url>
Navigate to the project directory: cd ProjectManagementSystem
Build the project: mvn clean install
Run the application: mvn spring-boot:run
Access the API documentation at: http://localhost:8080/swagger-ui/index.html
API Endpoints:

POST /api/projects: Create a new project
GET /api/projects: Retrieve all projects
GET /api/projects/{id}: Retrieve a project by ID
PUT /api/projects/{id}: Update a project by ID
DELETE /api/projects/{id}: Delete a project by ID

Usage:

Create a new project:

curl -X POST -H "Content-Type: application/json" -d 
'{
"name":"Project1","description":"Description1","startDate":"2024-04-28","endDate":"2024-05-30"
}' 
http://localhost:8080/api/projects

Retrieve all projects:
curl http://localhost:8080/api/projects

Retrieve a project by ID:
curl http://localhost:8080/api/projects/{id}

Update a project by ID:
curl -X PUT -H "Content-Type: application/json" -d 
'{
"name":"UpdatedProject1","description":"UpdatedDescription1","startDate":"2024-04-28","endDate":"2024-06-30"
}' 
http://localhost:8080/api/projects/{id}

Delete a project by ID:
curl -X DELETE http://localhost:8080/api/projects/{id}


Author:
Rahul Devligri
