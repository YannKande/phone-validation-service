package com.yan.locationservice.utils.dummy_response;

import lombok.SneakyThrows;

public class mainTest {

    @SneakyThrows
    public static void main(String[] args) {



        System.out.println(Validate_Number_Response.successfullyValidateTo_json("811632979"));

        System.out.println(Validate_Number_Response.credentialNotfound(""));

    }


}
