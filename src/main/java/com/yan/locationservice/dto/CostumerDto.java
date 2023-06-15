package com.yan.locationservice.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CostumerDto {

    private String id;
    private String firstName;
    private String lastName;
    @JsonProperty("phoneNumber")
    private String phoneNumber;


}
