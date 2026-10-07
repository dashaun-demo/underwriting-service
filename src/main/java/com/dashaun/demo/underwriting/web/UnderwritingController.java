package com.dashaun.demo.underwriting.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnderwritingController {

    @GetMapping("/api/underwriting/rules")
    public String rules() {
        return "[{\"code\":\"R-101\",\"name\":\"driving-history\"},"
                + "{\"code\":\"R-102\",\"name\":\"claims-frequency\"},"
                + "{\"code\":\"R-103\",\"name\":\"credit-tier\"}]";
    }

    @GetMapping("/api/underwriting/risk/{customerId}")
    public String risk(@PathVariable String customerId) {
        return "{\"customerId\":\"" + customerId + "\","
                + "\"riskScore\":0.18,\"tier\":\"PREFERRED\","
                + "\"rulesEvaluated\":3,\"decision\":\"ACCEPT\"}";
    }
}
