package com.wipro.coupon.service;

import java.util.List;

import com.wipro.coupon.dto.request.Coupon;
import com.wipro.coupon.exception.CouponCodeNotFoundException;

public interface CouponService {
    Coupon saveCoupon(Coupon coupon);
    List<Coupon> findAll();
    Coupon findByCouponCode(String couponCode) throws CouponCodeNotFoundException;
}
