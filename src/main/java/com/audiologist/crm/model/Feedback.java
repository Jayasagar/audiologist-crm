package com.audiologist.crm.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Feedback {

    @Id
    private String id;
    private int rating;
    private String comment;
    private String email;
    private String patientId;
    private String appointmentId;
}
