package com.yan.locationservice.controller;

import com.yan.locationservice.controller.impl.VerifyPhoneImpl;
import com.yan.locationservice.dto.PhoneValidRequest;
import com.yan.locationservice.services.VerifyPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerifyPhoneController implements VerifyPhoneImpl {

    @Autowired
    VerifyPhoneService service;


    @Override
    public ResponseEntity<String> loc(String  number) {

        return service.locationByPhoneNumber(number);
    }



    @Override
    public ResponseEntity<String> see(PhoneValidRequest request) {

       String resp= "okoko"+request.getNumber();

        return ResponseEntity.ok(resp);

    }
}
