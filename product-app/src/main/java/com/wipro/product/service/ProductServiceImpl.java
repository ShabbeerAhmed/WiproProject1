package com.wipro.product.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wipro.product.dto.request.Product;
import com.wipro.product.exception.ProductIdNotFoundException;
import com.wipro.product.repository.ProductRepository;
import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    public ProductServiceImpl(@Autowired ProductRepository productRepository) {
        super();
        this.productRepository = productRepository;
    }

    @Transactional
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product findById(int id) throws ProductIdNotFoundException {
        Optional<Product> optionalContainer = productRepository.findById(id);

        if (optionalContainer.isPresent())
            return optionalContainer.get();
        else
            throw new ProductIdNotFoundException(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findByProductName(String productName) {
        // TODO Auto-generated method stub
        return productRepository.findByProductName(productName);
    }
}
