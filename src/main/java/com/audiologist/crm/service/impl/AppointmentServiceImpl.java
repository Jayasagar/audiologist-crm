package com.audiologist.crm.service.impl;

import com.audiologist.crm.dto.AppointmentFeedback;
import com.audiologist.crm.model.Appointment;
import com.audiologist.crm.model.Feedback;
import com.audiologist.crm.repo.AppointmentRepository;
import com.audiologist.crm.repo.FeedbackRepository;
import com.audiologist.crm.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private @Autowired AppointmentRepository appointmentRepository;
    private @Autowired FeedbackRepository feedbackRepository;

    @Override
    public List<AppointmentFeedback> getAppointmentsWithFeedback() {
        List<AppointmentFeedback> appointmentFeedbacks = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.findAll();

        appointments.parallelStream().forEach(appointment -> {
            AppointmentFeedback appointmentFeedback = new AppointmentFeedback();
            appointmentFeedback.setCompleted(appointment.isCompleted());
            appointmentFeedback.setDescription(appointment.getDescription());
            appointmentFeedback.setAppointmentDate(appointment.getDateTime());
            feedbackRepository.findByAppointmentId(appointment.getId()).parallelStream().forEach(feedback -> {
                appointmentFeedback.setComment(feedback.getComment());
                appointmentFeedback.setCommentDate(feedback.getDate());
                appointmentFeedback.setRating(feedback.getRating());
                appointmentFeedback.setEmail(feedback.getEmail());
            });

            appointmentFeedbacks.add(appointmentFeedback);
        });

        return appointmentFeedbacks;
    }
}
