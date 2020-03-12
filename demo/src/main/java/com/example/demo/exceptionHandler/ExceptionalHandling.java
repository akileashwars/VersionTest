package com.example.demo.exceptionHandler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestControllerAdvice
@EnableWebMvc
public class ExceptionalHandling {
		@ExceptionHandler(Exception.class)
public 	ResponseEntity<Object> handleException(HttpServletRequest request)
	{
		StringBuffer requestURL = request.getRequestURL();
		String[] split = requestURL.toString().split("/");
		    return new ResponseEntity<Object>(
		   split[split.length-1] + "detail contains invalid Data"  , HttpStatus.BAD_REQUEST);
		
	}
	
		
}
