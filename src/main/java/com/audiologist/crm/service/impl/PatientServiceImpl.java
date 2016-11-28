package com.audiologist.crm.service.impl;

import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.dto.PatientFeedback;
import com.audiologist.crm.model.CRMHttpResponse;
import com.audiologist.crm.model.Feedback;
import com.audiologist.crm.repo.FeedbackRepository;
import com.audiologist.crm.repo.PatientRepository;
import com.audiologist.crm.service.AppointmentService;
import com.audiologist.crm.service.PatientService;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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
    public CRMHttpResponse saveFeedback(String patinetId, String appointmentId, PatientFeedback patientFeedback) {
        Feedback feedback = new Feedback();
        feedback.setPatientId(patinetId);
        feedback.setRating(patientFeedback.getRating());
        feedback.setComment(patientFeedback.getComment());
        feedback.setEmail(patientFeedback.getEmail());
        feedback.setAppointmentId(appointmentId);
        feedback.setDate(DateTime.now());
        CRMHttpResponse response = new CRMHttpResponse();
        try {
            Feedback save = feedbackRepository.save(feedback);
        } catch (Exception e) {
            // TODO: Improve it.
            response.setCode("123456");
            response.setMessage("Internal error occurred. Try after sometime.");
            response.setHttpStatusCode(HttpStatus.EXPECTATION_FAILED);
        }
        response.setHttpStatusCode(HttpStatus.OK);
        return response;
    }
}
