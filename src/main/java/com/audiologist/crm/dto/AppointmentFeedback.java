package com.audiologist.crm.dto;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.util.List;

@Getter @Setter
public class AppointmentFeedback {

    private String description;
    private boolean completed;
    private DateTime appointmentDate;
    private List<PatientFeedback> feedbacks;
}
