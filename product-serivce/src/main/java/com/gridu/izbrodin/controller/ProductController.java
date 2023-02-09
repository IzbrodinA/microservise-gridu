package com.gridu.izbrodin.controller;

import com.gridu.izbrodin.entity.Product;
import com.gridu.izbrodin.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping(value = "{id}")
    private ResponseEntity<Product> getProductById(@PathVariable String id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping(value = "/sku/{skuId}")
    private ResponseEntity<List<Product>> getProductsBySku(@PathVariable String skuId) {
        return ResponseEntity.ok(productService.findBySku(skuId));
    }

}
