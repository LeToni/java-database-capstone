# Healthcare Management System - Schema Architecture

## Overview
This healthcare management system is built with Spring Boot, implementing a hybrid architecture that combines both MVC pattern for server-side rendering and REST API endpoints for client-server communication. The application manages healthcare operations including patient management, doctor scheduling, appointments, and prescription tracking.

## Architecture Components

### 1. Presentation Layer

#### MVC Controllers (Server-Side Rendering)
- **Admin Dashboard**: Uses Thymeleaf templates for administrative interface
- **Doctor Dashboard**: Server-side rendered views for doctor-specific functionality
- **Templates Location**: `src/main/resources/templates/`
  - `admin/adminDashboard.html`
  - `doctor/doctorDashboard.html`

#### REST Controllers (Client-Side Rendering)
- **Patient Services**: API endpoints for patient management
- **Appointment Services**: RESTful APIs for appointment booking and management
- **Prescription Services**: MongoDB-backed prescription APIs
- **Frontend**: Static HTML pages with JavaScript for dynamic interactions
  - Location: `src/main/resources/static/pages/`

### 2. Service Layer
The application implements a clean separation of concerns through a comprehensive service layer that acts as an intermediary between controllers and data access layers. This ensures:
- Business logic encapsulation
- Transaction management
- Data validation and transformation
- Cross-cutting concerns handling

### 3. Data Access Layer

#### Dual Database Architecture

**MySQL Database (Relational Data)**
- **Technology**: JPA/Hibernate with Spring Data JPA
- **Entities**:
  - Patient records and demographics
  - Doctor profiles and specializations
  - Appointment scheduling data
  - Administrative user accounts
- **Benefits**: ACID compliance, complex relationships, structured data integrity

**MongoDB Database (Document Storage)**
- **Technology**: Spring Data MongoDB
- **Collections**:
  - Prescription documents with flexible schema
  - Medical history records
  - Treatment notes and observations
- **Benefits**: Flexible schema, scalable document storage, complex nested data structures

### 4. Frontend Architecture

#### Static Resources Structure
```
src/main/resources/static/
├── index.html (Main entry point)
├── pages/ (Application views)
├── js/ (JavaScript modules)
│   ├── components/ (Reusable UI components)
│   ├── services/ (API service layer)
│   └── config/ (Configuration files)
├── assets/
│   ├── css/ (Stylesheets)
│   └── images/ (Static images)
```

#### Key JavaScript Modules
- **Patient Management**: `patientDashboard.js`, `loggedPatient.js`
- **Appointment System**: `patientAppointment.js`, `updateAppointment.js`
- **Prescription Management**: `addPrescription.js`
- **Administrative Tools**: `adminDashboard.js`, `doctorDashboard.js`
- **Utilities**: `render.js`, `util.js` for common functionality

## Data Flow Architecture

1. **Client Request Initiation**: User interacts with the frontend (web browser) by submitting forms, clicking buttons, or making API calls through JavaScript modules

2. **Controller Layer Processing**: Spring Boot controllers (either MVC or REST) receive the HTTP requests and perform initial request validation and routing

3. **Service Layer Delegation**: Controllers delegate business logic processing to the appropriate service classes, which contain the core application logic and business rules

4. **Data Validation & Transformation**: Service layer validates input data, applies business rules, and transforms data into the appropriate format for database operations

5. **Repository Layer Interaction**: Services interact with repository interfaces (Spring Data JPA for MySQL, Spring Data MongoDB for document storage) to perform CRUD operations

6. **Database Operations Execution**: 
   - **MySQL Database**: Handles relational data (patients, doctors, appointments, admin users) through JPA entities
   - **MongoDB Database**: Manages document-based data (prescriptions, medical records) through document models

7. **Response Assembly & Delivery**: Data flows back through the layers - repositories return data to services, services process and format the response, controllers prepare the final output (either Thymeleaf-rendered HTML pages or JSON responses for REST APIs), and the response is sent back to the client

## Technology Stack

### Backend
- **Framework**: Spring Boot
- **Web Layer**: Spring MVC + Spring REST
- **Template Engine**: Thymeleaf (for admin/doctor views)
- **Data Access**: Spring Data JPA + Spring Data MongoDB
- **Database**: MySQL + MongoDB

### Frontend
- **Core**: HTML5, CSS3, Vanilla JavaScript
- **Architecture**: Component-based JavaScript modules
- **Communication**: Fetch API for REST endpoint consumption

## Benefits of This Architecture

1. **Flexibility**: Hybrid approach allows both server-side and client-side rendering
2. **Scalability**: Dual database strategy optimizes for different data types
3. **Maintainability**: Clear separation of concerns and modular structure
4. **Performance**: Efficient data access patterns for both relational and document data
5. **User Experience**: Rich client-side interactions where needed, server-side rendering for admin interfaces