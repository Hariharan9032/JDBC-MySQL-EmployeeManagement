# Employee Data Management System

This project demonstrates a simple Employee Data Management System using JDBC connectivity to store and manage employee data in a MySQL database.

## Features

- Insert new employee records
- Find employee records by ID
- Update employee salary
- Delete employee records
- Fetch all employee records

## Technologies Used

- Java
- JDBC
- MySQL

## Setup and Installation

1. **Clone the repository**:
    ```bash
    git clone https://github.com/yourusername/EmployeeDataManagementJDBC.git
    cd EmployeeDataManagementJDBC
    ```

2. **Set up MySQL database**:
    - Install MySQL if not already installed.
    - Create a new database named `jdbc_test`.
    - Create an `employee` table in the `jdbc_test` database using the following SQL script:
      ```sql
      CREATE TABLE employee (
          eid INT PRIMARY KEY,
          name VARCHAR(50),
          salary DOUBLE,
          designation VARCHAR(50),
          address VARCHAR(100),
          mobile BIGINT
      );
      ```

3. **Update database credentials**:
    - Update the `getConnection` method in the `Company.java` file with your MySQL username and password:
      ```java
      con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc_test?user=yourusername&password=yourpassword");
      ```

4. **Compile and run the project**:
    ```bash
    javac -d bin src/Company/Company.java
    java -cp bin:lib/mysql-connector-java-8.0.23.jar Company.Company
    ```

## Usage

1. Run the application and you will see the following options:
    ```
    Employee Details Enter Portal

    1. Insert Record
    2. Find
    3. Update
    4. Delete
    5. Fetch all records
    6. Exit
    ```

2. Follow the on-screen instructions to perform various operations on the employee records.
