package com.wipro.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.product.dto.request.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(int id);

    Product findByProductName(String productName);
}
