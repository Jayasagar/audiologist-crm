package com.audiologist.crm.dto;

import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

@Getter @Setter
public class AppointmentOverview {
    private DateTime dateTime;
    private String description;
    private String patientId;
}
