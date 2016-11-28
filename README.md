# On-going documentation!!!

### audiologist-crm
Simple web service (api) which allows audiologists (hearing care professionals) to manage their customers appointments

> Please refer to [Rest-api](https://github.com/Jayasagar/audiologist-crm/blob/master/REST-API.md) and [tech stack info](https://github.com/Jayasagar/audiologist-crm/blob/master/Design-solution.md) for more information on Rest apis and tech stack

### Links
#### Github: 
* https://github.com/Jayasagar/audiologist-crm
#### Travis: CI/CD
* https://travis-ci.org/Jayasagar/audiologist-crm
#### Application AWS link: 
* http://35.164.208.17:8903/audiologist/api/v1
#### Application Monitoring 
* http://35.164.208.17:8904/health

### Steps to run application
* Clone the project
* ./gradlew build
* java -jar build/libs/audiologist-spring-boot-1.0.jar
* Run Tests
** ./gradlew test

### Out of Scope
* Authentication/Authorization
* User Interface

### Limitations
* Partially Done - Production-ready features such as metrics, health checks and externalized configuration
* Pagination support
* Logging
* Business specific error codes
* Full HATEOAS support

### Known issues
* Swagger - Spring Data Rest : https://github.com/springfox/springfox/issues/699

