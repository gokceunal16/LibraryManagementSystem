# BBM473 Project: Library Management System, Phase 3

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
- [Folder Structure](#folder-structure)
- [Frontend Dependencies](#frontend-dependencies)
- [Backend Dependencies](#backend-dependencies)


## Features

- React-based frontend with modern UI components.
- Backend API implemented using Spring Boot.
- PostgreSQL database integration for data storage.
- Sample components and API endpoints for reference.
- Obtain statistical data such as the count of tables and the count of records in your own tables. 
- Perform DML (Data Manipulation Language) operations like insert, delete, and update.
- Display all user tables and their statistical data in a grid view.
- Support for inserting, deleting, and updating records in the database. 

## Prerequisites

Before running this project, ensure that you have the following prerequisites installed:

- Node.js and npm: [Download Node.js](https://nodejs.org)
- Java Development Kit (JDK): [Download JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- PostgreSQL: [Download PostgreSQL](https://www.postgresql.org/download/)

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/celikmustaa/LibraryManagement.git

2. Change to the project directory:

   ```bash
   cd LibraryManagement
   
3. Install the dependencies for both the frontend and backend:
   ```bash
   cd frontend
   npm install react-scripts --save
   npm install

   cd ../backend
   ./mvnw install
4. Configure the database connection:
 MUSTAFA BURASI SENDE 

5. Run the frontend development server:

   ```bash
   cd frontend
   npm start
   ```
   Open your web browser and visit http://localhost:3000 to see the application in action.
   

## Folder Structure
The project's folder structure is as follows:

   ```bash
   LibraryManagement/
   |- backend/ # Backend Spring Boot application
   |- frontend/ # Frontend React application
   ```

## Frontend Dependencies
The frontend of this project relies on the following major dependencies:

- @mui/material: Material-UI component library for React.
- @testing-library: Testing utilities for React components.
- axios: Promise-based HTTP client for the browser and Node.js.
- material-react-table: Library for creating tables with sorting, filtering, and pagination.
- prop-types: Runtime type checking for React props.

Please refer to the package.json file in the frontend directory for the complete list of frontend dependencies.

## Backend Dependencies
The backend of this project relies on the following major dependencies:

- Spring Boot: Framework for creating Java-based applications.
- Spring Data JDBC: JDBC-based data access framework for Spring.
- Spring Data R2DBC: R2DBC-based data access framework for Spring.
- Spring Boot Starter Jersey: Starter for building RESTful web services using Jersey.
- Spring Boot Starter Web: Starter for building web applications using Spring MVC.
- Spring Boot Starter Web Services: Starter for building SOAP web services using Spring Web Services.
- Spring Boot Starter Webflux: Starter for building reactive web applications using Spring WebFlux.
- PostgreSQL Driver: Connector for interacting with the PostgreSQL database.
- Tomcat Jasper: Implementation of the Jasper API, used for JSP rendering.

Please refer to the pom.xml file in the backend directory for the complete list of backend dependencies.