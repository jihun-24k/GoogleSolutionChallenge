package com.example.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchReq {

    @JsonProperty("WGS84_LAT")
    private double latitude;

    @JsonProperty("WGS84_LON")
    private double longitude;

    // 페이지는 1, 갯수는 10개로 고정
    private int pageNo = 1;
    private int numOfRows = 10;

    // uri를 빌드해서 보내줌
    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();

        map.add("WGS84_LAT", String.valueOf(latitude));
        map.add("WGS84_LON", String.valueOf(longitude));
        map.add("pageNo", String.valueOf(pageNo));
        map.add("numOfRows", String.valueOf(numOfRows));
        return map;
    }
}
