package com.yan.locationservice.utils.dummy_response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yan.locationservice.dto.ValidateResponse;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Validate_Number_Response {

    private   boolean valid=false;
    private String number;
    private String localFormat;
    private String internationalFormat;
    private String countryPrefix;
    private String countryCode;
    private String countryName;
    private String location;
    private String carrier;
    private String lineType;


    public  static ObjectMapper mapper=new ObjectMapper();

    @SneakyThrows
    public static String successfullyValidateTo_json(String number)
            {


        ValidateResponse response= new ValidateResponse();

        response.setValid(true);
        response.setNumber(number);
        response.setLocalFormat("59807526");
        response.setInternationalFormat("mu:+230"+number);
        response.setCountryPrefix("+230");
        response.setCountryCode("MU");
        response.setCountryName("Mauritius (Republic of");
        response.setLocation("-DKkç9302°3°94835637343221");
        response.setCarrier("Emtel Ltd");
        response.setLineType("mobile");

        return mapper.writeValueAsString(response);
    }


    public static Validate_Number_Response successfullyValidateTo_Object(String number){

        return Validate_Number_Response.builder()
                .valid(true)
                .number(number)
                .localFormat(number)
                .internationalFormat("mu:230 "+number)
                .countryPrefix("+230")
                .countryCode("MU")
                .countryName("Mauritius (Republic of")
                .location("")
                .carrier("Emtel Ltd")
                .lineType("mobile")
                .build();
    }


    @SneakyThrows
    public static String credentialNotfound(String apiKey)  {
        if(apiKey.isEmpty()){
            String message="The apikey is null";

            return  null;
        }

        return null;
    }
}
