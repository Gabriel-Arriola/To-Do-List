# To-Do-List Application

This is a simple to-do list application built with Java and Spring Boot. It allows users to manage their tasks by adding, marking as completed, and deleting tasks.

# Prerequisites
Java 17 or higher installed on your machine
Maven installed on your machine (if you want to build the project from source)


# Getting Started

1- Clone the repository to your local machine:
git clone https://github.com/Gabriel-Arriola/To-Do-List.git

2- Navigate to the project directory:
cd todo-list

3- Build the project using Maven:
mvn clean package

4- Run the application:
java -jar target/todo-list-1.0.0.jar

Replace todo-list-1.0.0.jar with the actual name of the generated JAR file.

5- Once the application is running, you can access it at http://localhost:8080 use api-docs: http://localhost:8080/swagger-ui/index.html

# API Endpoints
GET /api/v1/tasks/ : Find all task
GET /api/v1/tasks/{id} : Find task by ID
GET /api/v1/tasks/pending : Find all pending tasks
GET /api/v1/tasks/completed : Find all completed tasks
POST /api/v1/tasks/ : Creates new task
PUT /api/v1/tasks/{id} : Updates existing task
DELETE /api/v1/tasks/{id} : Deletes existing task


# Technologies Used
Java
Spring Boot
Spring Data JPA
H2 Database (embedded)
Maven


