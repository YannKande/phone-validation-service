package com.yan.locationservice.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;



@Configurable
@RequiredArgsConstructor
public class RestTemplateConfig {

    private final RestTemplateHeaderInterceptor interceptor;
    @Bean
    public RestTemplateBuilder restTemplate(){

        RestTemplateBuilder restTemplate = new RestTemplateBuilder() ;
        restTemplate.build().getInterceptors().add(interceptor);

        return restTemplate;

    }
}
