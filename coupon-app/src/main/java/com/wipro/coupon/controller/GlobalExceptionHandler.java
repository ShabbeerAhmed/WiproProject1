package com.wipro.coupon.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.wipro.coupon.dto.response.ErrorResponse;
import com.wipro.coupon.exception.CouponCodeNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CouponCodeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCouponIdNotFoundException(CouponCodeNotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.toString());
        errorResponse.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
