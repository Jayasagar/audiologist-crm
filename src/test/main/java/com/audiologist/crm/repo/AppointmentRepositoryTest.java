package com.audiologist.crm.repo;

import com.audiologist.crm.Application;
import com.audiologist.crm.FongoConfig;
import com.audiologist.crm.model.Appointment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class, FongoConfig.class})
@WebAppConfiguration
public class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Before
    public void tearDown() {
        // Delete all records before running each test
        appointmentRepository.deleteAll();
    }

    @Test
    public void savePatientTest() {
        // Arrange
        Appointment appointment = createAppointment();
        // Act
        appointmentRepository.save(appointment);
        // Assert
        Assert.assertNotNull(appointment.getId());
    }

    private Appointment createAppointment() {
        Appointment appointment = new Appointment();
        appointment.setDescription("Test");
        appointment.setCompleted(false);
        return appointment;
    }
}
