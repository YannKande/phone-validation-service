package com.yan.locationservice;

import com.yan.locationservice.services.Impl.VerifyPhoneImpl;
import com.yan.locationservice.utils.dummy_response.Validate_Number_Response;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class verifyphonenumbertest {



    @Mock
    VerifyPhoneImpl service;
    private Validate_Number_Response response=new Validate_Number_Response();
    @BeforeEach
  void setup(){

        response= Validate_Number_Response.
                successfullyValidateTo_Object("0811632969");

        String r= String.valueOf(response);
    }

    @Test
    void locationByPhoneNumberTest(){

        //given
        String phone="0811632969";
        String r= String.valueOf(response);
        //when
          service.locationByPhoneNumber(phone);
         //then
         assertEquals(phone, response.getNumber());

 }

 @Test
 void shouldLocationByPhoneNumberNotfoundTest(){

        //given

     //when
     ResponseEntity<String>expected=service.locationByPhoneNumber(null);

     //then
     final ThrowableAssert anAssert = assertThatThrownBy((ThrowableAssert.ThrowingCallable) expected) instanceof ThrowableAssert ? ((ThrowableAssert) assertThatThrownBy((ThrowableAssert.ThrowingCallable) expected)) : null;
     ;
     assertThatThrownBy(()-> {
         assert anAssert != null;
         anAssert.getCause();
     });
 }



}
