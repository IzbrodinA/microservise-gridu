package com.gridu.izbrodin.service;

import com.gridu.izbrodin.entity.AvailabilityStatus;
import com.gridu.izbrodin.entity.Product;
import com.gridu.izbrodin.service.external.CatalogClient;
import com.gridu.izbrodin.service.external.InventoryClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {

    public static final String UNAVAILABLE_STATUS = "OUT_OF_STOCK";
    private final CatalogClient catalogClient;
    private final InventoryClient inventoryClient;

    public Product findById(String id) {
        Product product = catalogClient.getProductById(id);
        List<String> productById = getAvailableProductIds(List.of(product));
        if (productById.isEmpty()) {
            throw new IllegalArgumentException("Not Found available product by id=" + id);
        }
        return product;
    }

    public List<Product> findBySku(String sku) {
        List<Product> products = catalogClient.getProductBySku(sku);
        List<String> availableProductIds = getAvailableProductIds(products);
        return products
                .stream()
                .filter(product -> availableProductIds.contains(product.getId()))
                .toList();
    }

    private List<String> getAvailableProductIds(List<Product> products) {
        log.info("got products ids={}", products.stream().map(Product::getId).collect(Collectors.joining(",")));
        return inventoryClient.getProductById(products.stream().map(Product::getId).toArray(String[]::new))
                .stream()
                .filter(x -> !UNAVAILABLE_STATUS.equals(x.getStatus()))
                .map(AvailabilityStatus::getId).toList();
    }


}
