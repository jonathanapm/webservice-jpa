package com.webservicejpa.entities.enums;

import java.util.Arrays;

public enum OrderStatus {
    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderStatus(int code) {
        this.code = code;
    }

    public int getOrderStatus() { return this.code; }

    public static OrderStatus valueOf(int code) {
       return Arrays.stream(OrderStatus.values()).filter(x -> x.code == code).findFirst().get();
    }
}
