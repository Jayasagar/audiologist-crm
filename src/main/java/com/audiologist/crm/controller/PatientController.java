package com.audiologist.crm.controller;

import com.audiologist.crm.RequestMappingURI;
import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.dto.PatientFeedback;
import com.audiologist.crm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(RequestMappingURI.BASE_URL)
@Description("A controller for handling requests for Patient")
public class PatientController {

    private @Autowired PatientService patientService;

    // TODO: Don't ignore type query param!!
    @RequestMapping(value = "patients/{id}/appointments/filter", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public AppointmentOverview getNextAppointment(@PathVariable String id, @RequestParam String type) {
        // TODO: Extend AppointmentOverview with patient info instead patient ID
        return patientService.getNextAppointment(id);
    }

    @RequestMapping(value = "patients/{patientId}/appointments/{appointmentId}/feedbacks", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity saveFeedback(@PathVariable String patientId, @PathVariable String appointmentId, @RequestBody PatientFeedback patientFeedback) {
        return patientService.saveFeedback(patientId, appointmentId, patientFeedback);
    }

    @RequestMapping(value = "patients/{id}/appointments", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AppointmentOverview> getAppointments(@PathVariable String id) {
        return null;
    }
}
