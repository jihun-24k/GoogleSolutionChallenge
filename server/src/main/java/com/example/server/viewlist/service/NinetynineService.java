package com.example.server.viewlist.service;

import com.example.server.openapi.NinetynineClient;
import com.example.server.openapi.dto.SearchLocalReq;
import com.example.server.openapi.dto.SearchLocalRes;
import com.example.server.viewlist.dto.ViewListDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NinetynineService {

    private final NinetynineClient ninetynineClient;

    public SearchLocalRes search(double longitude, double latitude){
        // 지역 검색
        var searchLocalReq = new SearchLocalReq();
        searchLocalReq.setLongitude(longitude);
        searchLocalReq.setLatitude(latitude);

        var searchLocalRes = ninetynineClient.getLocation(searchLocalReq);
        // 결과를 리턴
        var localItem = searchLocalRes.getItems().stream().findFirst().get();

        var result = new SearchLocalRes();
        result.setResultCode(searchLocalRes.getResultCode());
        result.setResultMag(searchLocalRes.getResultMag());

        result.setItems(searchLocalRes.getItems());

        return result;
    }
}
