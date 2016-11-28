package com.audiologist.crm.service;

import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.dto.PatientFeedback;
import com.audiologist.crm.model.CRMHttpResponse;

public interface PatientService {
    AppointmentOverview getNextAppointment(String patientId);

    CRMHttpResponse saveFeedback(String patinetId, String appointmentId, PatientFeedback patientFeedback);
}
