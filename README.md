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
* Pagination support
* Logging
* Exception Handling
* Full HATEOAS support

## API Guide
* Profile API: http://localhost:8903/audiologist/api/v1/profile
* Patient profile API: http://localhost:8903/audiologist/api/v1/profile/patients
* Appointments profile API: http://localhost:8903/audiologist/api/v1/profile/appointments

#### User Story:1 Create Patient
POST - Actual Endpoint: http://localhost:8903/audiologist/api/v1/patients
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
#### User Story:2 Create Appointment for customer
POST - End point: http://localhost:8903/audiologist/api/v1/appointments
```json
{
	"dateTime":"2016-11-29T14:56:59.301Z",
	"description":"Severe audible issue",
	"patientId":"58382641a31488b36f80e125"
}
```

#### User Story:3 as an audiologist I want to see an overview of all appointments and their ratings
GET - End point: http://localhost:8903/audiologist/api/v1/appointments/feedbacks
Sample response
```json
[
  {
    "description": "Severe audible issue",
    "completed": false,
    "appointmentDate": "2016-11-29T14:56:59.301Z",
    "feedbacks": []
  },
  {
    "description": "General consulting",
    "completed": false,
    "appointmentDate": "2016-11-30T14:56:59.301Z",
    "feedbacks": [
      {
        "rating": 5,
        "comment": "Nice123",
        "email": "jay@jay.com"
      }
    ]
  },
  {
    "description": "audible issue",
    "completed": false,
    "appointmentDate": "2016-12-04T14:56:59.301Z",
    "feedbacks": []
  }
]
```

#### User Story:4 as an audiologist I want to see an overview of the next week’s appointments
GET - End point:: http://localhost:8903/audiologist/api/v1/appointments/filter?type=nextWeek
Sample response
```json
[
  {
    "dateTime": "2016-11-30T14:56:59.301Z",
    "description": "General consulting",
    "patientId": "58382641a31488b36f80e125"
  },
  {
    "dateTime": "2016-11-29T14:56:59.301Z",
    "description": "Severe audible issue",
    "patientId": "58382641a31488b36f80e125"
  }
]
```

#### User Story:5 as a customer I want to see my next appointment
GET - End point:: http://localhost:8903/audiologist/api/v1/patients/58382641a31488b36f80e125/appointments/filter?type=next

#### User Story:6 as a customer I want to rate my last appointment
POST - End point: http://localhost:8903/audiologist/api/v1/patients/58382641a31488b36f80e125/appointments/58382ce9a31488b36f80e128/feedbacks
```json
{
	"rating":"5",
	"comment":"Very experienced, however, would be great to maintain timings.",
	"email":"jay@jay.com"
}
```

## References
* http://openmymind.net/Multiple-Collections-Versus-Embedded-Documents/#10
* https://dzone.com/articles/when-use-mongodb-rather-mysql

## Known issues
* Swagger - Spring Data Rest : https://github.com/springfox/springfox/issues/699

