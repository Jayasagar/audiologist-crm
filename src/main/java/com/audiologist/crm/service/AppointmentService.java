package com.audiologist.crm.service;


import com.audiologist.crm.dto.AppointmentFeedback;
import com.audiologist.crm.dto.AppointmentOverview;

import java.util.List;

public interface AppointmentService {
    List<AppointmentFeedback> getAppointmentsWithFeedback();

    List<AppointmentOverview> getNextWeekAppointments();
}
