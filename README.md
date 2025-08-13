# Java OOP Concepts Practice

Welcome to your OOP learning journey in Java! This repository is designed to help you master Object-Oriented Programming concepts through practical examples.

## Prerequisites

- Java 17 or later
- Maven 3.8.6 or later
- Your favorite Java IDE (IntelliJ IDEA, Eclipse, VS Code, etc.)

## OOP Concepts with Problem Statements

### 1. Classes & Objects

**Example 1: Car Rental System**
Create a `Car` class that represents a car in a rental system. The class should:
- Track make, model, year, current speed, and engine status
- Allow starting/stopping the engine
- Support accelerating and braking
- Provide car information
- Include proper constructors and validation

**Example 2: Student Management System**
Design a `Student` class that:
- Stores student details (name, ID, age, courses)
- Allows enrolling/dropping courses
- Tracks GPA and academic standing
- Validates input data
- Generates student reports

**Example 3: Library Book Tracker**
Implement a `Book` class that:
- Tracks book details (title, author, ISBN, availability)
- Manages check-in/check-out status
- Handles due dates and late fees
- Supports searching and filtering

### 2. Encapsulation

**Example 1: Secure Bank Account**
Implement a `BankAccount` class that:
- Encapsulates account details (account number, holder name, balance)
- Provides controlled access through getters/setters
- Validates transactions (no negative amounts, sufficient funds)
- Prevents direct access to sensitive data
- Maintains transaction history

**Example 2: User Authentication System**
Create a `User` class that:
- Securely stores user credentials
- Implements password hashing
- Manages user sessions
- Enforces password policies
- Tracks login attempts

**Example 3: Temperature Controller**
Design a `Thermostat` class that:
- Encapsulates temperature settings
- Validates temperature ranges
- Implements auto-shutoff safety
- Provides controlled access to settings
- Logs temperature changes

### 3. Inheritance

**Example 1: Vehicle Hierarchy**
Create a class hierarchy for vehicles:
- Base `Vehicle` class with common properties (speed, capacity, etc.)
- `Car` and `Motorcycle` classes that extend Vehicle
- Specialized vehicles like `ElectricCar` that inherit from `Car`
- Demonstrate method overriding and `super` keyword usage

**Example 2: E-commerce Product System**
Design a product hierarchy:
- Base `Product` class with common attributes
- `PhysicalProduct` and `DigitalProduct` subclasses
- Specialized products like `Book` or `Software`
- Implement polymorphic pricing and shipping

**Example 3: Employee Management**
Create an employee hierarchy:
- Base `Employee` class with common properties
- `FullTimeEmployee` and `PartTimeEmployee` subclasses
- Specialized roles like `Manager` or `Contractor`
- Implement polymorphic salary calculation

### 4. Polymorphism

**Example 1: Shape Calculator**
Design a system where:
- A base `Shape` class defines an abstract `calculateArea()` method
- Different shapes (`Circle`, `Rectangle`, `Triangle`) implement this method
- A `ShapePrinter` class can print any shape's area without knowing its concrete type
- Demonstrate both compile-time and runtime polymorphism

**Example 2: Notification System**
Create a notification system with:
- Base `Notification` class with `send()` method
- Different notification types (`EmailNotification`, `SMSNotification`, `PushNotification`)
- A `NotificationService` that can send any type of notification
- Support for different message formats and delivery methods

**Example 3: Payment Processor**
Implement a payment processing system:
- Base `PaymentMethod` class with `processPayment()`
- Different payment types (`CreditCard`, `PayPal`, `BankTransfer`)
- A `Checkout` class that processes payments without knowing the specific type
- Support for different validation and processing rules

### 5. Abstraction

**Example 1: Payment Gateway**
Create an abstract `PaymentGateway` class that:
- Defines the payment process flow
- Has abstract methods for authorization and processing
- Concrete implementations for different payment methods (CreditCard, PayPal, UPI)
- Hides implementation details from the client code

**Example 2: Database Connection**
Design an abstract `DatabaseConnection` class that:
- Defines common database operations
- Has abstract methods for query execution
- Concrete implementations for different databases (MySQL, PostgreSQL, MongoDB)
- Encapsulates connection management

**Example 3: File Exporter**
Create an abstract `FileExporter` class that:
- Defines the export process
- Has abstract methods for format-specific operations
- Concrete implementations for different formats (PDF, CSV, Excel)
- Handles common tasks like file validation and error handling

### 6. Immutability

**Example 1: Transaction Record**
Design an immutable `Transaction` class that:
- Represents a financial transaction
- Contains transaction details (ID, amount, timestamp, status)
- Ensures thread-safety
- Provides methods that return new instances instead of modifying state

**Example 2: Configuration Settings**
Create an immutable `AppConfig` class that:
- Stores application configuration
- Loads settings from a file/API
- Prevents modification after creation
- Provides thread-safe access to settings

**Example 3: Address Book Entry**
Design an immutable `Contact` class that:
- Stores contact information (name, phone, email, address)
- Validates input on creation
- Returns new instances for updates
- Supports value-based equality

## Project Structure

```
java-oop-practice/
├── src/
│   ├── main/java/com/oop/practice/
│   │   ├── models/                  # Model classes
│   │   │   ├── car/
│   │   │   ├── bank/
│   │   │   ├── vehicle/
│   │   │   ├── shapes/
│   │   │   ├── payment/
│   │   │   └── transaction/
│   │   └── exercises/              # Exercise runners
│   │       └── OOPExercises.java
│   └── test/                       # Test cases
└── pom.xml
```

## Getting Started

1. Clone this repository
2. Open the project in your IDE
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Start with any concept by implementing the model classes and testing them

## How to Use This Repository

1. For each concept, implement the model classes in the appropriate package
2. Write test cases to verify your implementation
3. Run the `OOPExercises` class to test your implementations
4. Follow the SOLID principles in your implementations
5. Document your code with clear comments

## Best Practices

- Follow Java naming conventions
- Write clean, self-documenting code
- Include input validation
- Handle edge cases
- Write unit tests for your code
- Commit your progress regularly

Happy coding! 🚀
