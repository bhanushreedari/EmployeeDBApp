# EmployeeDBApp

This is a simple *Java console application* that demonstrates how to perform *CRUD operations* (Create, Read, Update, Delete) on an *Employee Database* using *JDBC* with *MySQL*.

---

## 📌 *Task Objective*

- *Connect Java to MySQL* using *JDBC Driver (MySQL Connector/J)*.
- Use *Connection, **PreparedStatement, **ResultSet*.
- Master basic *SQL operations* from Java.
- Learn how to use *JDBC* securely with *PreparedStatements*.

---

## ⚙ *Tools Used*
- *MySQL Server*
- *MySQL Connector/J* (.jar file)
- *VS Code* 
- *Command Line* or *Terminal*

---

## ✅ *How it Works*

1. *Connect* to a local MySQL database.
2. Use a simple *console menu* to:
   - Add an employee
   - View all employees
   - Update an employee
   - Delete an employee
3. Uses *PreparedStatement* to prevent SQL injection.
4. Displays output in the console.

## 📂 *Project Structure
├── EmployeeDBApp.java
├── mysql-connector-j-9.3.0.jar

## ⚡ *How to Run*

1️⃣*Create your database and table*

Run this in your MySQL server:
```sql
CREATE DATABASE employee_db;

USE employee_db;

CREATE TABLE employees (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    designation VARCHAR(100),
    salary DOUBLE,
    PRIMARY KEY (id)
);

2️⃣**Compile**

javac -cp ".;mysql-connector-j-9.3.0.jar" EmployeeDBApp.java

3️⃣**Run**

java -cp ".;mysql-connector-j-9.3.0.jar" EmployeeDBApp

🔍 Check Data
To see data directly in MySQL:
USE employeedb;
SELECT * FROM employees;

