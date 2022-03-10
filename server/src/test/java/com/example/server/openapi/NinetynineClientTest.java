package com.example.server.openapi;

import com.example.server.openapi.dto.SearchLocalReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NinetynineClientTest {

    @Autowired
    private NinetynineClient ninetynineClient;

    @Test
    public void ninetynineClientTest(){
        var search = new SearchLocalReq();
        search.setLatitude(37.488132562487905);
        search.setLongitude(127.08515659273706);

        var result = ninetynineClient.getLocation(search);
        System.out.println(result);
    }
}
