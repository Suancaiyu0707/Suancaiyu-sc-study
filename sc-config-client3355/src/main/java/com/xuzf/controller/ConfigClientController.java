package com.xuzf.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigClientController {

    @Value("${username}")
    private String username;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return username;
    }
}
