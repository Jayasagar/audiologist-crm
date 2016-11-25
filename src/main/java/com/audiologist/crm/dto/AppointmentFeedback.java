package com.audiologist.crm.dto;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter @Setter
public class AppointmentFeedback {
    private DateTime commentDate;
    private String description;
    private boolean completed;
    private int rating;
    private String comment;
    private DateTime appointmentDate;
    private String email;
}
