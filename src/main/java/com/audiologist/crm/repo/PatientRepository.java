package com.audiologist.crm.repo;

import com.audiologist.crm.model.Appointment;
import com.audiologist.crm.model.Patient;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface PatientRepository extends MongoRepository<Patient, String> {


}
