package com.example.hobiday_backend.domain.performance.controller;

import com.example.hobiday_backend.domain.performance.service.PerformanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class PerformanceController {
    private final PerformanceService performanceService;
    @GetMapping("/parsing")
    public void runTesT() throws ParserConfigurationException, IOException, SAXException {
        performanceService.save();
    }
}
