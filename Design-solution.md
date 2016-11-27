## Current solution 
Leveraged the power of Spring Boot production ready capabilities and built this simple audiologist CRM application functionality! 

## Solution in Mind
* Idea is to use micro service architecture with the following components 
* Hypermedia-driven REST service with Spring HATEOAS -- NOT FULLY implemented

|Component Name| Component Purpose|
| ------------- | ------------- |
|crm-audiologist-repository|Exposes REST APIS for audiologist functionality and also for data storage|
|crm-audiologist-java-sdk|Client SDK for crm-audiologist-repository. Eg: crm-backend can use this|
|crm-patient-repository|Exposes REST APIS for Patient functionality and also for data storage|
|crm-patient-java-sdk|Client SDK for crm-patient-repository. Eg: crm-backend can use this|
|crm-backend|Actual public facing component for web application|

## Tech Stack
* Spring Boot
* Spring Data Rest
* Spring Data MongoDB
* Spring Web (Spring REST)
* Spring Test
* Gradle

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
    ** Run service as a background
* Travis for CI/CD -- DONE
** Run the build/tests after every commit
** Push to artifactory repo

## References
* http://openmymind.net/Multiple-Collections-Versus-Embedded-Documents/#10
* https://dzone.com/articles/when-use-mongodb-rather-mysql
* http://www.vinaysahni.com/best-practices-for-a-pragmatic-restful-api