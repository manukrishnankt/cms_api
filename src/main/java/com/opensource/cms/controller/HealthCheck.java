package com.opensource.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

@RestController
public class HealthCheck {
    @Autowired
    Environment environment;

    @GetMapping("/")
    public String health() {
        return "Service is Running OK!";
    }

    @GetMapping("/backend")
    public String backend() {
        System.out.println("Inside MyRestController::backend...");
        String serverPort = environment.getProperty("local.server.port");
        System.out.println("Port : " + serverPort);

        return "Hello form Backend!!! " + " Host : localhost " + " :: Port : " + serverPort;
    }
}
