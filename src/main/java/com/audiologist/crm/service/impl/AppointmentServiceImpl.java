package com.audiologist.crm.service.impl;

import com.audiologist.crm.dto.AppointmentFeedback;
import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.dto.PatientFeedback;
import com.audiologist.crm.model.Appointment;
import com.audiologist.crm.repo.AppointmentRepository;
import com.audiologist.crm.repo.FeedbackRepository;
import com.audiologist.crm.service.AppointmentService;
import com.audiologist.crm.utils.DateUtil;
import com.google.common.collect.Lists;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {
    private @Autowired AppointmentRepository appointmentRepository;
    private @Autowired FeedbackRepository feedbackRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    // FIXME: Pagination support
    @Override
    public List<AppointmentFeedback> getAppointmentsWithFeedback() {
        List<AppointmentFeedback> appointmentFeedbacks = new ArrayList<>();
        List<Appointment> appointments = appointmentRepository.findAll();

        appointments.stream().forEach(appointment -> {
            AppointmentFeedback appointmentFeedback = new AppointmentFeedback();
            appointmentFeedback.setCompleted(appointment.isCompleted());
            appointmentFeedback.setDescription(appointment.getDescription());
            appointmentFeedback.setAppointmentDate(appointment.getDateTime());

            List<PatientFeedback> patientFeedbacks = new ArrayList<>();
            feedbackRepository.findByAppointmentId(appointment.getId()).stream().forEach(feedback -> {
                PatientFeedback patientFeedback = new PatientFeedback();
                patientFeedback.setComment(feedback.getComment());
                patientFeedback.setRating(feedback.getRating());
                patientFeedback.setEmail(feedback.getEmail());
                patientFeedbacks.add(patientFeedback);
            });

            appointmentFeedback.setFeedbacks(patientFeedbacks);
            appointmentFeedbacks.add(appointmentFeedback);
        });

        return appointmentFeedbacks;
    }

    @Override
    public List<AppointmentOverview> getNextWeekAppointments() {
        // Get Next week Monday to pull nextAppointments week appointments
        DateTime next = DateUtil.getStartOfTheWeek();

        List<Appointment> appointments = appointmentRepository.nextAppointments(next, next.plusDays(5));

        List<AppointmentOverview> appointmentOverviews = Lists.newArrayList();
        appointments.parallelStream().forEach(appointment -> {
            AppointmentOverview appointmentOverview = new AppointmentOverview();
            appointmentOverview.setDescription(appointment.getDescription());
            appointmentOverview.setDateTime(appointment.getDateTime());
            appointmentOverview.setPatientId(appointment.getPatientId());
            appointmentOverviews.add(appointmentOverview);
        });
        return appointmentOverviews;
    }

    @Override
    public AppointmentOverview getPatientNextAppointment(String patientId) {

        Query query = new Query();
        query.with(new Sort(Sort.Direction.ASC,"dateTime"));
        query.addCriteria(new Criteria().andOperator(Criteria.where("patientId").is(patientId),
                Criteria.where("completed").is(false)));

        List<Appointment> appointments = mongoTemplate.find(query, Appointment.class);

        if (appointments != null && appointments.size()>0) {
            Appointment appointment = appointments.get(0);
            AppointmentOverview appointmentOverview = new AppointmentOverview();
            appointmentOverview.setDescription(appointment.getDescription());
            appointmentOverview.setDateTime(appointment.getDateTime());
            appointmentOverview.setPatientId(appointment.getPatientId());
            return appointmentOverview;
        }
        return null;
    }
}
