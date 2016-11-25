package com.audiologist.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
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
    private DateTime date;
}
