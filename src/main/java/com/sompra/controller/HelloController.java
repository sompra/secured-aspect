package com.sompra.controller;

import com.sompra.client.RestClient;
import com.sompra.entity.Hello;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Created by somprasong
 * Date: 2019-01-27
 * Time: 14:16
 */

@RestController
@RequestMapping("hello")
public class HelloController {

    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Autowired
    private RestClient restClient;

    private String uri = "https://api.chucknorris.io/jokes/random";

    @GetMapping
    public ResponseEntity<Hello> hello() {
        return restClient.getChuckNorris(uri);
    }
}
