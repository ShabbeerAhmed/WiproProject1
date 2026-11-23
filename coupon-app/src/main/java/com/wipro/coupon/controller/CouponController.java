package com.wipro.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.coupon.dto.request.Coupon;
import com.wipro.coupon.service.CouponService;

@RequestMapping("api/v1/coupons")
@RestController
public class CouponController {

    private CouponService couponService;

    @PostMapping
    //@RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Coupon> saveCoupon(@RequestBody Coupon coupon) {
        return new ResponseEntity<Coupon>(couponService.saveCoupon(coupon), HttpStatus.CREATED);
    }

    public CouponController(@Autowired CouponService couponService) {
        super();
        this.couponService = couponService;
    }

    @GetMapping("/{couponCode}")
    public ResponseEntity<Coupon> getCouponByCode(@PathVariable String couponCode) {
    	System.out.println("server2");
        return new ResponseEntity<Coupon>(couponService.findByCouponCode(couponCode), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Coupon>> getAllCoupon() {
        return new ResponseEntity<List<Coupon>>(couponService.findAll(), HttpStatus.OK);
    }
}
