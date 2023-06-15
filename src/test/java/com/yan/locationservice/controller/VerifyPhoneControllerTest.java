package com.yan.locationservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.locationservice.dto.PhoneValidRequest;

import com.yan.locationservice.services.Impl.VerifyPhoneImpl;
import com.yan.locationservice.utils.dummy_response.Validate_Number_Response;
import lombok.SneakyThrows;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class VerifyPhoneControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private VerifyPhoneImpl service;
    @Autowired
    private ObjectMapper mapper;
    PhoneValidRequest phone;

    private static Validate_Number_Response  response;

    @SneakyThrows
    @Test
    void ShouldLocationPhone_success() {

        String phoneNumber="0811632979";
        //given
        phone= PhoneValidRequest.builder()
                .number("0811632979").build();
        String data= mapper.writeValueAsString(phone);

       String response= mapper.writeValueAsString(
               Validate_Number_Response.successfullyValidateTo_Object(phoneNumber)
       );

        //when
        when(service.locationByPhoneNumber(String.valueOf(any(String.class)))).thenReturn(
                ResponseEntity.ok(response)
        );

        this.mockMvc.perform(post("/hello/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(data))
                .andExpect(status().isOk());

        System.out.println(response);

    }

    @Test
    void see() {
    }
}