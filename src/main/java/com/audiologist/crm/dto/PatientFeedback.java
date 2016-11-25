package com.audiologist.crm.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PatientFeedback {
    private int rating;
    private String comment;
    private String email;
}
