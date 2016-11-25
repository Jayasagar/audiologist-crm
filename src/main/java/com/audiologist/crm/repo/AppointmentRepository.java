package com.audiologist.crm.repo;

import com.audiologist.crm.model.Appointment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

}
