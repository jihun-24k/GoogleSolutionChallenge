package com.example.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchReq {

    @JsonProperty("WGS84_LAT")
    private float latitude;

    @JsonProperty("WGS84_LON")
    private float longitude;

    private int pageNo;

    private int numOfRows;
}
