package com.audiologist.crm.repo;

import com.audiologist.crm.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {

}
