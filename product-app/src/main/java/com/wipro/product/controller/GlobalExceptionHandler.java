package com.wipro.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wipro.product.dto.response.ErrorResponse;
import com.wipro.product.exception.ProductIdNotFoundException;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleProductIdNotFoundException(ProductIdNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.toString());
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorResponse> handleFeignException(FeignException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        HttpStatus status = HttpStatus.valueOf(ex.status());
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(ex.contentUTF8());
            errorResponse.setMessage(root.path("message").asText());
        } catch (Exception e) {
            errorResponse.setMessage("Error calling Coupon Service");
        }
        errorResponse.setStatus(status);
        return new ResponseEntity<>(errorResponse, status);
    }
}
