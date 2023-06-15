package com.yan.locationservice.controller.impl;



import com.yan.locationservice.dto.PhoneValidRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;


import static com.yan.locationservice.utils.Constants.*;


public interface VerifyPhoneImpl{

    @PostMapping(value = LOCATION_COSTUMER_ENDPOINT,consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Validation by Phone number", notes = "This method will help to find details location for costumers"
            , response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "merchant as creat / update"),
            @ApiResponse(code = 400, message = "object merchant is not valid")
    })
    ResponseEntity<String> loc(@RequestBody String number);


    @PostMapping( value = APP_ROOT+"/see/", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> see(@RequestBody PhoneValidRequest request);
}


