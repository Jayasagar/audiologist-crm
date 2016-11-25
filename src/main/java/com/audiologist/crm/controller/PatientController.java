package com.audiologist.crm.controller;

import com.audiologist.crm.RequestMappingURI;
import com.audiologist.crm.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RequestMappingURI.BASE_URL)
public class PatientController {

    private @Autowired PatientService patientService;

//    @ApiOperation(value = "Creates an Patient")
//    @RequestMapping(value = "/patients123", method = RequestMethod.POST)
//    public ResponseStatus createPatient(@RequestBody final Patient patient) {
//
//        return null;
//    }
}
