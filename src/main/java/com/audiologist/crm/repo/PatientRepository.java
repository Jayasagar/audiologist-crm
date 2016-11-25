package com.audiologist.crm.repo;

import com.audiologist.crm.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;


@RepositoryRestResource(collectionResourceRel = "patients", path = "patients")
public interface PatientRepository extends MongoRepository<Patient, String> {

}
