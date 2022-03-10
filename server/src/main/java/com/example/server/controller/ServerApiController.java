package com.example.server.controller;

import com.example.server.openapi.dto.SearchLocalRes;
import com.example.server.viewlist.dto.ViewListDto;
import com.example.server.viewlist.service.NinetynineService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.nio.charset.Charset;

@Slf4j
@RestController
@RequestMapping("/api/server")
@RequiredArgsConstructor
public class ServerApiController {

    String serviceKey = "bX3mLyh/nh5x5sNBnzmkZ0JKn2hg1bEs7l4JphBFijlmTY1yZsqfs7BRCMvNn3OAyZAev4ey7fmyZhuUwzPLpQ==";

    private final NinetynineService ninetynineService;

    @GetMapping("/location")
    public String sc(){

        URI uri = UriComponentsBuilder
                .fromUriString("http://apis.data.go.kr")
                .path("/B552657/ErmctInfoInqireService/getEgytLcinfoInqire")
                .queryParam("serviceKey", serviceKey)
                .queryParam("WGS84_LON",127.08515659273706)
                .queryParam("WGS84_LAT",37.488132562487905)
                .queryParam("numOfRows",10)
                .queryParam("pageNo",1)
                .encode(Charset.forName("UTF-8"))
                .build()
                .toUri();

        log.info("uri : {}", uri);

        RestTemplate restTemplate = new RestTemplate();

        RequestEntity<Void> req = RequestEntity
                .get(uri)
                .build();

        ResponseEntity<String> result = restTemplate.exchange(req, String.class);
        return result.getBody();
    }

    @GetMapping("/locate")
    public SearchLocalRes search(@RequestParam double longitude, @RequestParam double latitude){
        return ninetynineService.search(longitude, latitude);
    }
}
