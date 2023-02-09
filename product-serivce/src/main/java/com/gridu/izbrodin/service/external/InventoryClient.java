package com.gridu.izbrodin.service.external;

import com.gridu.izbrodin.entity.AvailabilityStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient(value = "inventory-service", fallback = InventoryClient.FallbackInventory.class)
public interface InventoryClient {

    @RequestMapping(
            method = RequestMethod.GET,
            value = "/inventory/v1",
            consumes = "application/json")
    List<AvailabilityStatus> getProductById(@RequestParam("ids") String[] ids);

    @Component
    @Slf4j
    class FallbackInventory implements InventoryClient {
        @Override
        public List<AvailabilityStatus> getProductById(String[] ids) {
            log.error("FALLBACK 503 service inventory unavailable");
            throw new RuntimeException("503 service inventory unavailable");
        }
    }
}


