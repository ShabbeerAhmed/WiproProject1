package com.wipro.product.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wipro.product.dto.request.Coupon;

@FeignClient("COUPON-APP")
public interface CouponFeignClient {

    @GetMapping("/api/v1/coupons/{couponCode}")
    public ResponseEntity<Coupon> getCouponByCode(@PathVariable String couponCode);
}
