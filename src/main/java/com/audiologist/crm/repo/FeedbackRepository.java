package com.audiologist.crm.repo;

import com.audiologist.crm.model.Feedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface FeedbackRepository extends MongoRepository<Feedback, String> {

    @RestResource(path="feedbackByAppointmentId", rel="feedbackByAppointmentId")
    List<Feedback> findByAppointmentId(@Param("appointmentId") String appointmentId);
}
