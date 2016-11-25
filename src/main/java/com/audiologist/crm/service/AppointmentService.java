package com.audiologist.crm.service;


import com.audiologist.crm.dto.AppointmentFeedback;

import java.util.List;

public interface AppointmentService {
    List<AppointmentFeedback> getAppointmentsWithFeedback();
}
