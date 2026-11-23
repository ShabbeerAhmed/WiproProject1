package com.wipro.coupon.exception;

public class CouponCodeNotFoundException extends RuntimeException {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String couponCode;

    public CouponCodeNotFoundException(String couponCode) {
        // TODO Auto-generated constructor stub
        super("Coupon code not found for id : " + couponCode);
        this.couponCode = couponCode;
    }

    @Override
    public String toString() {
        return "Code " + couponCode + " not found";
    }
}
