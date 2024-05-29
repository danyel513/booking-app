# Vacation Booking Web Application

### Project by:
- **Baluti Laura Loredana**
- **Cotoc Daniel Beniamin**

---

## Table of Contents
- [Motivation](#motivation)
- [Backend](#backend)
  - [Technologies Used](#technologies-used)
  - [Database Structure](#database-structure)
  - [Examples](#examples)
  - [Password Encryption](#password-encryption)
  - [Testing](#testing)
- [Frontend](#frontend)
  - [User Interaction](#user-interaction)
  - [User Homepage](#user-homepage)
- [Use Case Diagram](#use-case-diagram)
- [Project Statistics](#project-statistics)
- [Future Improvements](#future-improvements)
- [Credits](#credits)

---

## Motivation

### Why a Booking Application?

- **Addressing an Urgent Market Need**: In today's digital era, everything from shopping to vacation bookings happens online. Our application provides a fast, simple, and accessible platform for booking hotels, restaurant tables, or event tickets, meeting this demand head-on.
  
- **Enhancing User Experience**: We aim to make bookings as easy and enjoyable as possible. With a modern and user-friendly interface, users can make reservations from any device, saving time and avoiding the stress of traditional booking methods.

---

## Backend

### Technologies Used
- **Language**: Java
- **Framework**: Spring Boot
- **Database**: 4 tables with automatic indexing and autoincrement.

### Database Structure
- **Hotel**: Provides getter and setter methods for hotel properties.
- **Room**: Defines the rooms in a hotel.
- **Reservation**: Creates user reservations, defining vacation dates and chosen hotels.
- **User**: Stores application user data.

### Examples
- Adding data to the `hotels` table using JDBC framework.

### Password Encryption
- Passwords are encrypted before storage, ensuring they are not saved as plain text.

### Testing
- **@Test**: Inserts an object into the table using a custom method, reads the last inserted hotel, and compares.
- **@AfterAll**: Removes inserted test data.
- **@BeforeAll**: Initializes the test object.

---

## Frontend

### User Interaction
- On launch, users are greeted with a sign-up page where they can create a new account or log into an existing one.

### User Homepage
- Provides users with recommendations for exclusive vacation spots, detailed descriptions, and the option to book directly through the application.
- Allows adding, removing, and modifying available rooms to reflect current availability.

---

## Use Case Diagram

### User and Hotel Interactions
- Both users and hotels need to log in to perform any actions.
- New users or hotels visiting the page for the first time have the option to create a new account.

---

## Project Statistics

- **Backend**: 20 files structured using Maven.
- **Frontend**: 5 Angular components, totaling 18 files.
- **Total Code**: Several thousand lines of code across ~40 files, accumulated over 3 weeks (4-5 hours/day).

### Commit Structure
- **Total Commits**: 25
- **Feature Branches**: Used for different features to simulate a real project environment.
  - **Backend**: 17 commits by Dani
  - **Frontend**: 8 commits by Laura

---

## Future Improvements

1. Email validation system.
2. Password reset system.
3. Messaging service between users and hotels.
4. Hotel star rating system.
5. Personalized feedback with pros and cons.
6. AI-based personalized recommendations based on travel history.


