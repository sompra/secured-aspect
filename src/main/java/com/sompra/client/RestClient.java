package com.sompra.client;

import com.sompra.advice.Secured;
import com.sompra.entity.Hello;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by somprasong
 * Date: 2019-01-28
 * Time: 06:03
 */


@Secured
@Component
public class RestClient {

    @Autowired
    private RestTemplate restTemplate;

    //@Secured
    public ResponseEntity<Hello> getChuckNorris(String uri) {
        return restTemplate.getForEntity(uri, Hello.class);
    }
}
