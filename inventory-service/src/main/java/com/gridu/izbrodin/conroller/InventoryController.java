package com.gridu.izbrodin.conroller;

import com.gridu.izbrodin.entity.AvailabilityStatus;
import com.gridu.izbrodin.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/inventory/v1")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping(value = "")
    public ResponseEntity<List<AvailabilityStatus>> getStatusIds(@RequestParam("ids") List<String> ids) {
        return ResponseEntity.ok(inventoryService.getAvailability(ids));
    }
}