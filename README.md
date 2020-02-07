# Assignment: Order placement system

An interview assignment given by Inmeta AS as a preperation for technical interview.

## Prerequisites
- IntelliJ (Or other IDE), MySql (or other database suited for the task)

## Maximum time allowed 
- No limit

You are free to structure the project as you like. During the technical interview we will be looking at your decision making (architecture, design, etc), technical implementation, and how you go about to solve a given problem.

## Description of assignment

Your solution should be extendable by request from the customer (The moving company) and should be ready for production usage. 

Create an application that a sales consultant working at a moving company will use to place / find / edit / delete orders on behalf of customers.

The company that the sales consultant works at offers these services for their customers:
- Moving
- Packing
- Cleaning

When placing an order, the sales consultant will need the following information from the customer:
- Name
- Phone number
- Email
- Address he's moving from
- Address he's moving to
- What service they are ordering
- Date for when the service is to be carried out
- A text field where the sales consultant can add a note to the order, for example: `The customer won't be available till 12pm`

Create a web application that satisfies the following user stories:
- As a sales consultant, I want to place an order for a customer.
- As a sales consultant, I want to find an order that I've previously placed for a customer.
- As a sales consultant, I want to edit an order that I've previously placed for a customer.
- As a sales consultant, I want to delete an order that I've previously placed for a customer.

## Exercise 1 - Service API
Write an API (Rest service) that satisfies the user stories and does the business logic. In exercise 2, you will create a web application that will use the API.

Requirements: Java - You can use spring boot if you like.

## Exercise 2 - Web
Write a web-application that satisfies the user stories. The web application will use the API built in exercise 1. 

Requirements: React, Vue or Angular preferred (Pure HTML / CSS / JS will be accepted. You can add any other js library if needed). Preferably, use GULP/Webpack to run and pack the web application.
