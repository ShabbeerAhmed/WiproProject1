package com.wipro.product.service;

import java.util.List;

import com.wipro.product.dto.request.Product;
import com.wipro.product.exception.ProductIdNotFoundException;

public interface ProductService {
    Product saveProduct(Product product);

    Product findById(int id) throws ProductIdNotFoundException;

    List<Product> findAll();

    Product findByProductName(String productName);
}
