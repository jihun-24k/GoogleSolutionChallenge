package com.example.server.openapi;

import com.example.server.openapi.dto.SearchLocalReq;
import com.example.server.openapi.dto.SearchLocalRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.Charset;

@Component
@Slf4j
public class NinetynineClient {

    @Value("${open_api.service_key}")
    private String serviceKey;

    @Value("${open_api.url.local}")
    private String localUrl;

    public SearchLocalRes getLocation(SearchLocalReq searchLocalReq){
        var uri = UriComponentsBuilder
                .fromUriString(localUrl)
                .queryParam("serviceKey", serviceKey)
                .queryParams(searchLocalReq.toMultiValueMap())
                .build()
                .encode(Charset.forName("UTF-8"))
                .toUri();

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .build();

        var result = restTemplate.exchange(req, SearchLocalRes.class);
        return result.getBody();
    }
}
