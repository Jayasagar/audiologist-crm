package com.audiologist.crm.service.impl;

import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.model.Appointment;
import com.audiologist.crm.repo.PatientRepository;
import com.audiologist.crm.service.AppointmentService;
import com.audiologist.crm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private AppointmentService appointmentService;

    @Override
    public AppointmentOverview getNextAppointment(String patientId) {
        return appointmentService.getPatientNextAppointment(patientId);
    }
}
