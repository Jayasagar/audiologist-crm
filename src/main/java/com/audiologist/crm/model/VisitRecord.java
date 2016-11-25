package com.audiologist.crm.model;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter
@Setter
public class VisitRecord {
    private DateTime date;
    private String notes;
    private String prescription;

}
