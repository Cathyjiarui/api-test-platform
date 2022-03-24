package com.example.apitestplatform.controller;

import com.example.apitestplatform.service.impl.NetworkRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pro/v1/networkRequest")
public class NetworkRequestServiceImplController {

    @Autowired
    private NetworkRequestServiceImpl networkRequestService;

    @GetMapping("test")
    public String test() {
        return networkRequestService.get();
    }
}
