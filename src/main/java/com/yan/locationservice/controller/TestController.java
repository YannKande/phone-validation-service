package com.yan.locationservice.controller;

import com.yan.locationservice.dto.PhoneValidRequest;
import com.yan.locationservice.dto.ValidateResponse;
import com.yan.locationservice.services.VerifyPhoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.yan.locationservice.utils.Constants.APP_ROOT;

@RestController
@Log4j2
@Api(APP_ROOT)
@RequestMapping()
public class TestController {

    @Autowired
    VerifyPhoneService service;

    @PostMapping("/hello/")
    @ApiOperation(value = "Validation by Phone number", notes = "This method will help to find details location for costumers"
            , response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "merchant as creat / update"),
            @ApiResponse(code = 400, message = "object merchant is not valid")
    })

    public ResponseEntity<String> response(@RequestBody PhoneValidRequest say){

        log.info("hello"+say);
        String number= say.getNumber();

        return service.locationByPhoneNumber(number);
    }


    @GetMapping("")
    public String hello(){
        String say="Welcome To Location service V1";
        return say;
    }
}
