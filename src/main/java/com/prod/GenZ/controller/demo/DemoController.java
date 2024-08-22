package com.prod.GenZ.controller.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo")
public class DemoController {


    @GetMapping
    public ResponseEntity<String> sayHello(
            @RequestHeader(name="Authorization") String token
    ){
        System.out.println("####### my token : " + token);

        return ResponseEntity.ok("Pro Hello !!!!!!!!!");
    }
}
