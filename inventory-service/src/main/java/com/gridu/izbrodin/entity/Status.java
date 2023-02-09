package com.gridu.izbrodin.entity;

import java.util.Random;

public enum Status {

    IN_STOCK, STOCKED_ON_DEMAND, OUT_OF_STOCK;

    private static final Random PRNG = new Random();

    public static Status randomStatus() {
        Status[] directions = values();
        return directions[PRNG.nextInt(directions.length)];
    }
}
