package com.example.server;

import com.example.server.dto.SearchReq;
import com.example.server.dto.SearchRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Component
@Slf4j
public class OurServer {

    String serviceKey = "bX3mLyh/nh5x5sNBnzmkZ0JKn2hg1bEs7l4JphBFijlmTY1yZsqfs7BRCMvNn3OAyZAev4ey7fmyZhuUwzPLpQ==";

    public SearchRes getLocation(SearchReq searchReq){
        var uri = UriComponentsBuilder
                .fromUriString("http://apis.data.go.kr")
                .path("/B552657/ErmctInfoInqireService/getEgytLcinfoInqire")
                .queryParam("serviceKey", serviceKey)
                .queryParams(searchReq.toMultiValueMap())
                .build()
                .encode()
                .toUri();

        log.info("uri : {}" , uri);

        var headers = new HttpHeaders();

        var httpEntity = new HttpEntity<>(headers);
        var responseType = new ParameterizedTypeReference<SearchRes>(){};

        var result = new RestTemplate().exchange(
                uri,
                HttpMethod.GET,
                httpEntity,
                responseType
                );
        return result.getBody();
    }
}
