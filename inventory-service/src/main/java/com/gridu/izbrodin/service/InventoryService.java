package com.gridu.izbrodin.service;

import com.gridu.izbrodin.entity.AvailabilityStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Slf4j
public class InventoryService {

    private final Map<String, AvailabilityStatus> cache = new ConcurrentHashMap<>();
    private final Random random = new Random();

    public List<AvailabilityStatus> getAvailability(List<String> ids) {
        randomlyRunLong();
        return ids.stream()
                .map(id -> cache.computeIfAbsent(id, AvailabilityStatus::new))
                .toList();
    }

    private void randomlyRunLong() {
        int randomNum = random.nextInt((3 - 1) + 1) + 1;
        if (randomNum == 3) {
            sleep();
        }
    }

    private void sleep() {
        log.info("Sleeeep zzzzzzzz");
        try {
            Thread.sleep(40000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
