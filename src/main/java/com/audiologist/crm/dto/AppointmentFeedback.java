package com.audiologist.crm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AppointmentFeedback {
    private String commentDate;
    private String description;
    private boolean completed;
    private int rating;
    private String comment;
    private String appointmentDate;
    private String email;
}
