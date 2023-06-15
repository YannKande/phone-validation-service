package com.yan.locationservice.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class RestTemplateHeaderInterceptor  implements ClientHttpRequestInterceptor {

   // @Value("${properties.api.location.access}")
    private String apiKey="H4WfcRQKJWI2B42Ub1Di3Q0w9Mol8bRN";

    @Override
    public ClientHttpResponse
    intercept(HttpRequest request,
              byte[] body,
              ClientHttpRequestExecution execution) throws IOException {
              request.getHeaders().set("apikey",apiKey);

        return execution.execute(request,body);
    }
}
