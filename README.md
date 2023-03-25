# Running the Backend locally
To run the backend, follow the instructions below.

## Requirements
- Java 11 or newer
- MySQL 8.0 or newer
- Maven
- IntelliJ IDEA

### Steps
1. **Create a MySQL Database**  
Create a new MySQL database named testdb. You can do this using tools such as phpMyAdmin, MySQL Workbench, or from the command line.

2. **Configure the Application**  
Open the `application.properties` file in the `src/main/resources` directory and fill it with your own information:  
```
spring.datasource.url=jdbc:mysql://localhost:3306/testdb?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false
spring.datasource.username=YOUR_DATABASE_USERNAME
spring.datasource.password=YOUR_DATABASE_PASSWORD

spring.main.allow-bean-definition-overriding=true
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
spring.jpa.hibernate.ddl-auto=update
```  
Replace `YOUR_DATABASE_USERNAME` and `YOUR_DATABASE_PASSWORD` with your MySQL database credentials. If you are using a different port than the default (3306), change it in the spring.datasource.url field.

3. **Run the Application**
The application will start running on the default port 8080. You can access the API using this URL: http://localhost:8080.



