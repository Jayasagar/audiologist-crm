package com.audiologist.crm.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter @Setter
public class CRMHttpResponse {
    private String code;
    private String message;
    private HttpStatus httpStatusCode;

}
