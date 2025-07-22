package com.vishalverma04.StudentSphere;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

    @GetMapping("/heath")
    public String healthCheck(){
        return "server is running well";
    }
}
