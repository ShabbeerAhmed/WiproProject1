package com.wipro.coupon.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.coupon.dto.request.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, String> {
    Coupon save(Coupon coupon);
    List<Coupon> findAll();
    Optional<Coupon> findByCouponCode(String code);
}
