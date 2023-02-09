package com.gridu.izbrodin.entity;


import lombok.Data;

@Data
public class AvailabilityStatus {

    private String id;
    private Status status;

    public AvailabilityStatus(String id) {
        this.id = id;
        this.status = Status.randomStatus();
    }
}

