package com.wipro.coupon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.coupon.dto.request.Coupon;
import com.wipro.coupon.exception.CouponCodeNotFoundException;
import com.wipro.coupon.repository.CouponRepository;

import jakarta.transaction.Transactional;

@Service
public class CouponServiceImpl implements CouponService {
    private CouponRepository couponRepository;

    public CouponServiceImpl(@Autowired CouponRepository couponRepository) {
        super();
        this.couponRepository = couponRepository;
    }

    @Transactional
    @Override
    public Coupon saveCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon findByCouponCode(String couponCode) throws CouponCodeNotFoundException {
        Optional<Coupon> optionalContainer = couponRepository.findByCouponCode(couponCode);
        if (optionalContainer.isPresent())
            return optionalContainer.get();
        else
            throw new CouponCodeNotFoundException(couponCode);
    }

    @Override
    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }
}
