package com.gridu.izbrodin.service.external;

import com.gridu.izbrodin.entity.Product;
import lombok.extern.slf4j.Slf4j;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value="catalog-service",fallback = CatalogClient.FallbackCatalog.class)
public interface CatalogClient {


    @RequestMapping(
            method= RequestMethod.GET,
            value="/catalog/v1/product/{id}",
            consumes="application/json")
    Product getProductById(@PathVariable("id") String id);

    @RequestMapping(
            method= RequestMethod.GET,
            value="/catalog/v1/product/sku/{sku}",
            consumes="application/json")
    List<Product> getProductBySku(@PathVariable("sku") String sku);

    @Component
    @Slf4j
    class FallbackCatalog implements CatalogClient {

        @Override
        public Product getProductById(String id) {
            log.error("FALLBACK 503 service catalog unavailable");
            throw new RuntimeException("503 service catalog unavailable");
        }

        @Override
        public List<Product> getProductBySku(String sku) {
            log.error("FALLBACK 503 service catalog unavailable");
            throw new RuntimeException("503 service catalog unavailable");
        }
    }
}
