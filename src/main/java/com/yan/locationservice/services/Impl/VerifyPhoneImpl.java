package com.yan.locationservice.services.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.locationservice.configs.RestTemplateConfig;
import com.yan.locationservice.dto.PhoneValidRequest;
import com.yan.locationservice.services.VerifyPhoneService;
import jdk.nashorn.internal.runtime.Context;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;

import static com.yan.locationservice.utils.Constants.LOCATION_VERIFY_PHONE_ENDPOINT;


@Service
@Log4j2
public class VerifyPhoneImpl implements VerifyPhoneService  {


    @Autowired
    private RestTemplateBuilder restTemplate;

    @Autowired
    private ObjectMapper mapper;


    @Override
    public ResponseEntity<String> locationByPhoneNumber(String request) {
        //String data=mapper.writeValueAsString(request);

        if (request.isEmpty()){
            log.info("number empty");

         new NullPointerException("phone vide");

             return (ResponseEntity<String>) ResponseEntity.badRequest();
        }

        HttpHeaders headers=new HttpHeaders();
        headers.add("apikey","H4WfcRQKJWI2B42Ub1Di3Q0w9Mol8bRN");
        HttpEntity entity = new HttpEntity  (headers);

       // log.info("valuer"+request);
        ResponseEntity<String> response= restTemplate.build().exchange(
                LOCATION_VERIFY_PHONE_ENDPOINT+request,HttpMethod.GET,entity,String.class);
       // String response=mapper.writeValueAsString(validateResponse.getBody());
        log.info("urlmatch"+LOCATION_VERIFY_PHONE_ENDPOINT+request);

        return ResponseEntity.ok(response).getBody();
    }
}
