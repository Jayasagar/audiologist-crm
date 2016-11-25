package com.audiologist.crm.repo;

import com.audiologist.crm.model.Appointment;
import org.joda.time.DateTime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AppointmentRepository extends MongoRepository<Appointment, String> {

    @Query("{ 'dateTime' : { $gt: ?0, $lt: ?1 } }")
    List<Appointment> nextAppointments(DateTime startDate, DateTime endDate);

    @Query("{ 'dateTime' : { $gt: ?0, $lt: ?1 } }")
    List<Appointment> patientNextAppointment(String patientId);
}
