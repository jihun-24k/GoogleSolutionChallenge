package com.example.server.openapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchLocalRes {

    private String resultCode;
    private String resultMag;
    private List<SearchItem> items;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchItem {
        private int rnum;
        private int cnt;
        private float distance;
        private String dutyAddr;
        private String dutyDiv;
        private String dutyDivName;
        private String dutyName;
        private String dutyTel1;
        private String endTime;
        private String hpid;
        private double latitude;
        private double longitude;
        private String startTime;
    }
}
