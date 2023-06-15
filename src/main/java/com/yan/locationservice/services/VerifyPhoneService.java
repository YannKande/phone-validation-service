package com.yan.locationservice.services;



import org.springframework.http.ResponseEntity;

public interface VerifyPhoneService {

  ResponseEntity<String> locationByPhoneNumber(String number);

}
