package com.example.server;

import com.example.server.dto.SearchReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OurServerTest {

    @Autowired
    private OurServer ourServer;

    @Test
    public void ourServerTest(){
        var search = new SearchReq();
        search.setLatitude(37.488132562487905);
        search.setLongitude(127.08515659273706);

        var result = ourServer.getLocation(search);
        System.out.println(result);
    }
}
