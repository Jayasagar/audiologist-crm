
## Tech Stack
* Spring Boot
* Spring Data Rest
* Spring Data MongoDB
* Spring Web (Spring REST)
* Hypermedia-driven REST service with Spring HATEOAS -- NOT FULLY implemented
* Spring Test 
## Libraries used
* Lombok
* Joda for Datetime
* Swagger
* Jackson
* Fongo for fake mongo for integration testing

## Tech Tasks
* Swagger for API - PARTIAL - Not fully implemented for all API as already we use hypermedia-driven REST service with Spring HATEOAS
* Deploy in AWS -- DONE
    ** Java installation
    ** MongoDB
    ** Deploy the app
* Travis for CI/CD -- DONE
** Run the build/tests after every commit
** Push to artifactory repo

## Solution approach
Idea is to use micro service architecture with the following components 

|Component Name| Component Purpose|
| ------------- | ------------- |
|crm-audiologist-repository|Exposes REST APIS for audiologist functionality and also for data storage|
|crm-audiologist-java-sdk|Client SDK for crm-audiologist-repository. Eg: crm-backend can use this|
|crm-patient-repository|Exposes REST APIS for Patient functionality and also for data storage|
|crm-patient-java-sdk|Client SDK for crm-patient-repository. Eg: crm-backend can use this|
|crm-backend|Actual public facing component for web application|