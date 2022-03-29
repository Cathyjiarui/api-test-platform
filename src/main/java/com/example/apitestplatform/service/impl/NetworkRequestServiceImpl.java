package com.example.apitestplatform.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.apitestplatform.service.NetworkRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NetworkRequestServiceImpl implements NetworkRequestService {

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public String GetRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("token",getToken());
        JSONObject jsonObject = new JSONObject();
        HttpEntity<JSONObject> request = new HttpEntity<>(jsonObject, headers);
        ResponseEntity<String> result = restTemplate.exchange("http://localhost:8088/api/v1/pri/user/find_by_token", HttpMethod.GET, request, String.class);
        JSONObject resultJson = JSONObject.parseObject(result.getBody());
        return resultJson.getString("data");
    }

    private String getToken() {
        JSONObject bodyData = new JSONObject();
        bodyData.put("phone", "13910527756");
        bodyData.put("pwd", "123456");
        ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:8088/api/v1/pri/user/login", bodyData, String.class);
        JSONObject resultJson = JSONObject.parseObject(result.getBody());
        return resultJson.getString("data");
    }
}
