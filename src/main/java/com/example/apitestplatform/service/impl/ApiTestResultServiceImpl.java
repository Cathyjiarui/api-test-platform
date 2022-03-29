package com.example.apitestplatform.service.impl;

import com.example.apitestplatform.mapper.ApiTestResultMapper;
import com.example.apitestplatform.service.ApiTestResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiTestResultServiceImpl implements ApiTestResultService {

    @Autowired
    private ApiTestResultMapper apiTestResultMapper;
}
