package com.portfolio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.model.AttributionRequest;
import com.portfolio.model.AttributionResponse;
import com.portfolio.service.AttributionService;

@RestController
@RequestMapping("/api/performance")
public class PerformanceController {

	@Autowired
    private AttributionService service;

    @PostMapping("/attribution")
    public AttributionResponse attribution(
            @RequestBody AttributionRequest request){

        return service.calculate(request);

    }
}
