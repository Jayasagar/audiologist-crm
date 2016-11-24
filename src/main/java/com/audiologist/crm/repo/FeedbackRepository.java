package com.audiologist.crm.repo;

import com.audiologist.crm.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends MongoRepository<Patient, String> {

}
