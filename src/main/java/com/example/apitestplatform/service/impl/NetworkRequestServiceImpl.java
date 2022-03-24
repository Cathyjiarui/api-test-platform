package com.example.apitestplatform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NetworkRequestServiceImpl {

    @Autowired
    private RestTemplate restTemplate;

    public String get() {
        return restTemplate.getForObject("http://www.weather.com.cn/data/sk/101010100.html", String.class);
    }
}
