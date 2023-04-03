package com.example.boardproject.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebServiceController {

    @GetMapping("/test")
    @ResponseBody
    public ResponseEntity<String> testFunction(){
        return ResponseEntity.ok("{test:\"test\"}");
    }
}
