package com.audiologist.crm.service;

import com.audiologist.crm.dto.AppointmentFeedback;
import com.audiologist.crm.model.Appointment;
import com.audiologist.crm.model.Feedback;
import com.audiologist.crm.repo.AppointmentRepository;
import com.audiologist.crm.repo.FeedbackRepository;
import com.audiologist.crm.service.impl.AppointmentServiceImpl;
import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AppointmentServiceImplTest {
    @InjectMocks private AppointmentServiceImpl appointmentService;
    @Mock private AppointmentRepository appointmentRepository;
    @Mock private FeedbackRepository feedbackRepository;

    @Test
    public void get_appointments_with_feedback_should_work() {

        Mockito.when(appointmentRepository.findAll()).thenReturn(Lists.newArrayList(new Appointment()));
        Mockito.when(feedbackRepository.findByAppointmentId("123")).thenReturn(Lists.newArrayList(new Feedback()));

        List<AppointmentFeedback> appointmentsWithFeedback = appointmentService.getAppointmentsWithFeedback();

        Assert.assertTrue(appointmentsWithFeedback.size() == 1);
    }

}
