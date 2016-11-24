package com.audiologist.crm.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class VisitRecord {
    private Date date;
    private String notes;
    private String prescription;

}
