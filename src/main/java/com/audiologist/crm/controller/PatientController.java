package com.audiologist.crm.controller;

import com.audiologist.crm.RequestMappingURI;
import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.dto.PatientFeedback;
import com.audiologist.crm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RequestMappingURI.BASE_URL)
public class PatientController {

    private @Autowired PatientService patientService;

    @RequestMapping(value = "patients/{id}/next", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AppointmentOverview getNextAppointment(@PathVariable String id) {
        return patientService.getNextAppointment(id);
    }

    @RequestMapping(value = "patients/{patinetId}/appointments/{appointmentId}/feedbacks", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveFeedback(@PathVariable String patinetId, @PathVariable String appointmentId, @RequestBody PatientFeedback patientFeedback) {
        return patientService.saveFeedback(patinetId, appointmentId, patientFeedback);
    }
}
