package com.gridu.izbrodin.service;

import com.gridu.izbrodin.entity.Product;
import com.gridu.izbrodin.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product findById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product with id not found"));
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public List<Product> findBySku(String sku) {
        return repository.findBySku(sku);
    }
}
