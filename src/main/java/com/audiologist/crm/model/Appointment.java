package com.audiologist.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.rest.core.annotation.Description;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
@Getter
@Setter
public class Appointment {
    @Id
    private String id;
    @Description("Appointment date")
    private DateTime dateTime;
    private String description;
    private String patientId;
    private boolean completed;
}
