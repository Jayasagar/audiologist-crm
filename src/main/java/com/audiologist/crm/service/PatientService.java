package com.audiologist.crm.service;

import com.audiologist.crm.dto.AppointmentOverview;

public interface PatientService {
    AppointmentOverview getNextAppointment(String patientId);
}
