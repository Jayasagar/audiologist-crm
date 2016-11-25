package com.audiologist.crm.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class Feedback {

    @Id
    private String id;
    private int rating;
    private String comment;
    private String email;
    private String patientId;
    private String appointmentId;
    private String date;
}
