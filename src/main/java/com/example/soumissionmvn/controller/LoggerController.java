package com.example.soumissionmvn.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Controller
public class LoggerController {
    @GetMapping("/loggerinfo")
    @ResponseBody
    public String info() {
        log.info("This is a sample INFO message");
        log.debug("Request hello world");
        log.info("Log info");

        return "Hello World!";
    }
}