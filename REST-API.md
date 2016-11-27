> NOTE: When running against AWS instance: replace localhost with http://35.164.208.17:8903/audiologist/api/v1

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
Eg: It gives Next week appointments Monday as the start date till Friday :)
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
