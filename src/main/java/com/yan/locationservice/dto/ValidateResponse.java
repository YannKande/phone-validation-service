package com.yan.locationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidateResponse {

     private boolean valid;
     private String number;
     private String localFormat;
     private String internationalFormat;
     private String countryPrefix;
     private String countryCode;
     private String countryName;
     private String location;
     private String carrier;
     private String lineType;

}
