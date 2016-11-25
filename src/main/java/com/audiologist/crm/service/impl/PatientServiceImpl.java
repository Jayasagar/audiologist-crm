package com.audiologist.crm.service.impl;

import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.dto.PatientFeedback;
import com.audiologist.crm.model.Appointment;
import com.audiologist.crm.model.Feedback;
import com.audiologist.crm.repo.FeedbackRepository;
import com.audiologist.crm.repo.PatientRepository;
import com.audiologist.crm.service.AppointmentService;
import com.audiologist.crm.service.PatientService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private AppointmentService appointmentService;

    @Override
    public AppointmentOverview getNextAppointment(String patientId) {
        return appointmentService.getPatientNextAppointment(patientId);
    }

    @Override
    public ResponseEntity saveFeedback(String patinetId, String appointmentId, PatientFeedback patientFeedback) {
        Feedback feedback = new Feedback();
        feedback.setPatientId(patinetId);
        feedback.setRating(patientFeedback.getRating());
        feedback.setComment(patientFeedback.getComment());
        feedback.setEmail(patientFeedback.getEmail());
        feedback.setAppointmentId(appointmentId);
        feedback.setDate(DateTime.now());
        try {
            Feedback save = feedbackRepository.save(feedback);
        } catch (Exception e) {
            // FIXME - Return proper status code
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }

        return new ResponseEntity(HttpStatus.OK);
    }
}
