package com.example.server.viewlist.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViewListDto {
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
    private float latitude;
    private float longitude;
    private String startTime;
}
