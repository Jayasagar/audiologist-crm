package com.audiologist.crm.repo;

import com.audiologist.crm.Application;
import com.audiologist.crm.FongoConfig;
import com.audiologist.crm.model.Patient;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {Application.class, FongoConfig.class})
public class PatientRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Before
    public void tearDown() {
        // Delete all records before running each test
        patientRepository.deleteAll();
    }

    @Test
    public void savePatientTest() {
        // Arrange
        Patient patient = createPatient("Sachin");
        // Act
        patientRepository.save(patient);
        // Assert
        Assert.assertNotNull(patient.getId());
    }

    private Patient createPatient(String name) {
        Patient patient = new Patient();
        return patient;
    }
}
