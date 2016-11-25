# On-going documentation!!!

# audiologist-crm
Simple web service (api) which allows audiologists (hearing care professionals) to manage their customers appointments

## Out of Scope
* Authentication/Authorization
* 

## Tech Stack
* Spring Boot
* Spring Data Rest
* Spring Data MongoDB
* Spring Web (Spring REST)
* Hypermedia-driven REST service with Spring HATEOAS

## Libraries used
* Lombok
* Swagger

## Tech Tasks
* Swagger for API - Not fully implemented for all API as already we use hypermedia-driven REST service with Spring HATEOAS
* Deploy in AWS
** Java installation
** MongoDB
** Deploy the app
* Travis for CI/CD
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

## Limitations
* Pagination support for an overview of all appointments and their ratings
* 

## APIS
#### Create Patient
```json
{
	"name":"Bob",
	"email":"bob@abc.com",
	"phone":"+49 172276",
	"notes":"Not a severe problem. However, he should use some medicine",
	"visitRecord": [ 
        {
            "date":"2016-11-25T14:56:59.301Z",
            "notes":"First visit notes",
            "prescription":"For now, medicine is good enough"
        },
        {
            "date":"2016-11-25T14:56:59.301Z",
            "notes":"Second visit notes",
            "prescription":"All set!!!"
    
        }
    ]
}
```
#### Create Appointment with patient ID
```json
{
	"date":"2016-11-25T14:56:59.301Z",
	"time":"12AM",
	"patientId":"5836f5eba3148894dd018b33"
}
```
## References
* http://openmymind.net/Multiple-Collections-Versus-Embedded-Documents/#10
* https://dzone.com/articles/when-use-mongodb-rather-mysql

## Known issues
* Swagger - Spring Data Rest : https://github.com/springfox/springfox/issues/699

