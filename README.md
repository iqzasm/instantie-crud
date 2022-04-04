# instantie-crud
Spring Boot Java Application using REST and JPA for CRUD operations

### Solution Approach

#### Swagger UI

###### API Contract Specs

OpenAPI(Swagger3) has been used for API Documentation. As soon as application is up, the swagger ui can be found under the below URI.

> http://localhost:9001/swagger-ui/

###### Tools & Technology Stack Used
* Java 11
* Spring Boot
* Spring Data JPA with H2 database
* REST API
* Lombok
* JUnit 5 & Mockito
* Maven (Build Tool)
* Logback (For logging)
* OpenAPI (Swagger Documentation)

#### Execute the application:
The spring boot application has two profiles defined.

* dev
* prod

In order to execute the application, below system environment value will define the profile to be used.

* SPRING_PROFILES_ACTIVE=`dev` or `prod`

After setting up the system environment values, you can execute the following commands.

##### Build without tests:
`./mvnw -DskipTests clean install`

##### Build with tests:
`./mvnw clean install`


To run only tests, execute the following.

`./mvnw test`

##### Note:
In order to test the application, CORS is enabled for all origins.

`app.origins = https://localhost:8085,*`

`*` is added for testing. This should be removed in prod environment

#### Postman collection:
Use this [postman collection](https://github.com/iqzasm/instantie-crud/blob/main/Instantie.postman_collection.json) to test the api service.
