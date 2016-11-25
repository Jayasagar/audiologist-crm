package com.audiologist.crm.service;

import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.dto.PatientFeedback;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface PatientService {
    AppointmentOverview getNextAppointment(String patientId);

    ResponseEntity saveFeedback(String patinetId, String appointmentId, PatientFeedback patientFeedback);
}
