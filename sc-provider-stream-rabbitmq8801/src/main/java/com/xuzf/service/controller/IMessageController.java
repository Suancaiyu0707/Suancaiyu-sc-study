package com.xuzf.service.controller;

import com.xuzf.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class IMessageController {
    @Resource
    private IMessageProvider provider;

    @GetMapping("/sendMessage")
    public String send(){
        return provider.send();
    }
}
