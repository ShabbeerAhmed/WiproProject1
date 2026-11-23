package com.wipro.coupon.dto.request;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import java.util.UUID;

@Entity
public class Coupon {
    @Id
    private String couponCode;
    private double discountPercentage;

    public Coupon() {
    }

    @PrePersist
    public void generateCode() {
        if (this.couponCode == null) {
            this.couponCode = "SAVE-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        }
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
}
