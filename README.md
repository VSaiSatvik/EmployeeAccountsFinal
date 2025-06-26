# Employee Account API

This is a simple **CRUD REST API** built using **Spring Boot**, **MySQL**, and **Swagger UI**. It manages employee account information and is ideal for learning API development with Java.

---

## 🔧 Tech Stack

- **Java 17+**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **MySQL**
- **Swagger UI (springdoc-openapi 2.3.2)**
- **IntelliJ IDEA**

---

## 📁 Project Structure

```
src/
 └── main/
     ├── java/
     │   └── com.crudapi.employeeaccountapi/
     │       ├── controller/       # REST controllers
     │       ├── model/            # Entity classes
     │       ├── repository/       # JPA repositories
     │       └── service/          # Business logic
     └── resources/
         ├── application.properties
         └── ...
```

---

## 🚀 How to Run

1. **Set up MySQL database**

Create a database in MySQL:

```sql
CREATE DATABASE employee_accounts;
```

2. **Configure `application.properties`**

Set your DB username and password:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_accounts
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

3. **Run the application**

You can run it via:

- IntelliJ IDEA: Right-click on the main class (`EmployeeAccountApiApplication.java`) → `Run`
- Or via terminal:
  ```bash
  ./mvnw spring-boot:run
  ```

---

## 📘 API Documentation

Swagger UI is enabled for testing and documenting the API.

📄 Visit:
```
http://localhost:8080/swagger-ui.html
```

---

## 📬 API Endpoints

| Method | Endpoint                  | Description              |
|--------|---------------------------|--------------------------|
| GET    | `/api/employees`          | Get all employees        |
| GET    | `/api/employees/{id}`     | Get employee by ID       |
| POST   | `/api/employees`          | Add new employee         |
| PUT    | `/api/employees/{id}`     | Update employee by ID    |
| DELETE | `/api/employees/{id}`     | Delete employee by ID    |

---

## ⚠️ Troubleshooting

- Ensure MySQL is running locally and credentials are correct.
- If Swagger doesn’t load, verify you're using the latest `springdoc-openapi-starter-webmvc-ui` dependency.

---

## 📄 License

This project is for educational purposes and is open for use and modification.
