/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.webcrawler.api;

import com.example.webcrawler.models.Fault;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Redi
 */
@Controller
public class ApiController {
    
    @Autowired
    private ApiService service;
    
    @RequestMapping(value = "/web-crawler", method = RequestMethod.GET)
    public ResponseEntity<Object> getJavascriptLibs(@RequestParam(name = "q") String input){
        Object response;
        int statusCode = 200;
        String url = "https://www.google.com/search?q=" + input + "&num=10";
        try {
            response = service.getTopLibs(url);
        } catch (Exception e) {
            statusCode = 500;
            response = new Fault("Fail", "Something went wrong. Try Again!", statusCode);
        }
        return new ResponseEntity<>(response, HttpStatus.valueOf(statusCode));
    }
    
}
