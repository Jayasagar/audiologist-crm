package com.audiologist.crm.controller;


import com.audiologist.crm.RequestMappingURI;
import com.audiologist.crm.dto.AppointmentFeedback;
import com.audiologist.crm.dto.AppointmentOverview;
import com.audiologist.crm.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(RequestMappingURI.BASE_URL)
public class AppointmentController {

    private @Autowired AppointmentService appointmentService;

    @RequestMapping(value = "appointments/feedbacks", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AppointmentFeedback> getAppointmentsWithFeedback() {
        return appointmentService.getAppointmentsWithFeedback();
    }

    // TODO: Extend to support other filter capabilities
    @RequestMapping(value = "appointments/filter", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public List<AppointmentOverview> getNextWeekAppointments(@RequestParam String type) {
        return appointmentService.getNextWeekAppointments();
    }
}
