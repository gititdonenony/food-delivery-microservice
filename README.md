Food Delivery App
A microservices-based Food Delivery Application built with Spring Boot, Docker, and Spring Cloud. This project is structured as a set of independent services for managing restaurants, orders, delivery, payments, and notifications, with a centralized configuration and service discovery.

Project Structure
The project follows a microservices architecture:

restaurant-service: Manages restaurant profiles and menus.
order-service: Handles user orders and tracks order status.
delivery-service: Manages deliveries and delivery personnel.
user-service: Manages user profiles, addresses, and contact info.
payment-service: Processes order payments.
notification-service: Sends notifications related to orders and delivery.
api-gateway: Acts as the single entry point for routing and authentication.
config-server: Centralized configuration server.
eureka-server: Manages service registration and discovery.
Getting Started
Prerequisites
Java 17: Install Java 17 or higher.
Maven: Ensure you have Maven installed for dependency management.
Docker: Install Docker and Docker Compose (if planning to use containers for databases).
Git: Set up Git to clone repositories and manage configurations.
Project Roadmap
Configuration Server and Eureka Server (Completed).
API Gateway setup.
Individual microservices (User, Restaurant, Order, etc.) with REST endpoints.
Inter-service communication with REST and messaging.
Security, resilience, and monitoring features.
