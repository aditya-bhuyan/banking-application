
# Banking Application

## Project Name and Description

**Banking Application** is an open-source full-stack project built using **Spring Boot** and **Thymeleaf**. The project showcases a basic banking system with functionality such as:

- Creating different types of customer accounts (Personal, Corporate, etc.)
- Managing accounts with relationships like Credit Cards, Savings Accounts, and Loans
- Performing transactions (credit, debit) and generating account statements

This project is designed to demonstrate how to use Spring Boot, MongoDB, and Thymeleaf for building full-stack applications.

---

## List of Files and Their Use

- **`pom.xml`**: The Maven build configuration file. It contains all the dependencies and configurations for the project.
- **`application.properties`**: Configuration file for the Spring Boot application, including MongoDB connection, logging, etc.
- **`BankingAppApplication.java`**: The main Spring Boot application class to run the project.
- **`BankAccountController.java`**: Controller handling CRUD operations for bank accounts.
- **`CustomerController.java`**: Controller handling CRUD operations for customers.
- **`BankAccountService.java`**: Service for business logic and interactions with the database regarding bank accounts.
- **`CustomerService.java`**: Service for business logic and interactions with the database regarding customers.
- **`BankAccount.java`**: Entity class representing a bank account.
- **`Customer.java`**: Entity class representing a customer.
- **`bank-account-create.html`**: Thymeleaf template to create a new bank account.
- **`bank-account-detail.html`**: Thymeleaf template to show details of a bank account.
- **`customer-create.html`**: Thymeleaf template to create a new customer.
- **`customer-list.html`**: Thymeleaf template to show a list of customers.
- **`customer-edit.html`**: Thymeleaf template to edit customer details.
- **`customer-detail.html`**: Thymeleaf template to view customer details.
- **`hello.html`**: A simple hello page for testing.
- **`test.html`**: A simple page used for testing the UI routing.

---

## Prerequisites

Before running the project, ensure you have the following installed and configured:

- **MongoDB**: The application uses MongoDB as the database. You can set up a MongoDB cluster, or install MongoDB locally. If you're using MongoDB Atlas, ensure you have the correct connection string.

    - MongoDB connection string:
      ```bash
      mongodb+srv://<db_username>:<db_password>@cluster0.80ubj.mongodb.net/
      ```

- **Java 17+**: The application requires Java 17 or higher.

- **Maven**: To build and run the application.

- **IntelliJ IDEA or any other Java IDE** (optional): For editing and running the project.

---

## Workflow

The general workflow of the application is as follows:

1. **URLs**: The base URLs for the customer and bank account management are:
    - **Customers**: `/customers`, `/customers/create`, `/customers/{id}`, `/customers/{id}/edit`, `/customers/{id}/delete`
    - **Bank Accounts**: `/bank-accounts`, `/bank-accounts/create`, `/bank-accounts/{id}`, `/bank-accounts/{id}/edit`, `/bank-accounts/{id}/delete`

2. **Files**:
    - **Controllers**: Handle the request mappings (e.g., `CustomerController.java`, `BankAccountController.java`).
    - **Services**: Contain the business logic and interactions with the MongoDB database (e.g., `CustomerService.java`, `BankAccountService.java`).
    - **Entity Classes**: Represent the structure of customer and bank account data in the database (e.g., `Customer.java`, `BankAccount.java`).

3. **Thymeleaf Templates**: Each URL endpoint has a corresponding Thymeleaf HTML template. These templates are located in `src/main/resources/templates/`:
    - `customer-create.html`, `customer-edit.html`, `customer-detail.html`
    - `bank-account-create.html`, `bank-account-detail.html`

   Thymeleaf templates are responsible for rendering the UI and displaying dynamic content from the controllers.

---

## How to Start, Test, Build, Run

### 1. **Starting the Application**:
To start the application locally, follow these steps:

- Clone the repository:
  ```bash
  git clone https://github.com/aditya-bhuyan/banking-application.git
  ```

- Navigate to the project directory:
  ```bash
  cd banking-app
  ```

- Build and run the project using Maven:
  ```bash
  mvn spring-boot:run
  ```

- The application will start on `http://localhost:8080`.

### 2. **Testing the Application**:
Once the application is running, you can access the following routes in your browser:
- **Customer List**: `http://localhost:8080/customers`
- **Create Customer**: `http://localhost:8080/customers/create`
- **Customer Details**: `http://localhost:8080/customers/{id}`
- **Create Bank Account**: `http://localhost:8080/bank-accounts/create`
- **Bank Account Details**: `http://localhost:8080/bank-accounts/{id}`

For testing purposes, you can use the simple `hello.html` or `test.html` pages as a sanity check.

### 3. **Building the Application**:
To build the application and create a deployable `.jar` file, run the following command:
```bash
mvn clean package
```
The built `.jar` file will be located in the `target/` directory.

To run the generated `.jar` file:
```bash
java -jar target/banking-app-<version>.jar
```

### 4. **Skipping Tests**:
To build the project while skipping the tests, use the following command:
```bash
mvn clean install -DskipTests
```

---

## Project License

This project is open-sourced under the **GNU General Public License v3.0 (GNU 3)**.

- **Maintainer**: Aditya Pratap Bhuyan
- **LinkedIn**: [Aditya Pratap Bhuyan](https://linkedin.com/in/adityabhuyan)

---

