package com.audiologist.crm.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonIgnoreProperties(ignoreUnknown = true)
@Document
@Getter @Setter
public class Patient {

    @Id
    private String id;
    private String name;
    private String email;
    private String phone;
    private String notes;
    private VisitRecord visitRecord;
}
