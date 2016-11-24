package com.audiologist.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
@Getter
@Setter
public class Appointment {
    @Id
    private String id;
    private Date date;
    private String time;
    private String patientId;
}
