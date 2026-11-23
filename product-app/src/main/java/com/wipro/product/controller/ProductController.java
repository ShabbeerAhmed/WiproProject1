package com.wipro.product.controller;

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

import com.wipro.product.client.CouponFeignClient;
import com.wipro.product.dto.request.Coupon;
import com.wipro.product.dto.request.Product;
import com.wipro.product.exception.ProductIdNotFoundException;
import com.wipro.product.service.ProductService;

@RequestMapping("api/v1/products")
@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    private CouponFeignClient couponFeignClient;

    @PostMapping
    //@RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return new ResponseEntity<Product>(productService.saveProduct(product), HttpStatus.CREATED);
    }

    public ProductController(@Autowired ProductService productService) {
        super();
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return new ResponseEntity<Product>(productService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/{productName}/{couponCode}")
    public ResponseEntity<Product> getProductByCouponCode(@PathVariable String productName, @PathVariable String couponCode) {
        Product product = productService.findByProductName(productName);
        Coupon coupon = couponFeignClient.getCouponByCode(couponCode).getBody();
        double discountPrice = product.getPrice() - coupon.getDiscountPercentage();
        product.setPrice(discountPrice);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<List<Product>>(productService.findAll(), HttpStatus.OK);
    }
}
