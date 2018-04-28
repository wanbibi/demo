package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobleException {

    @ResponseBody
    @ExceptionHandler
    public Object expHandler(Exception e) {
        return "error";
    }

}
