package com.audiologist.crm.controller;

import com.audiologist.crm.model.Patient;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PatientController {

    @ApiOperation(value = "Creates an Patient")
    @RequestMapping(value = "/patients", method = RequestMethod.POST)
    public ResponseStatus createPatient(@RequestBody final Patient patient) {

        return null;
    }
}
