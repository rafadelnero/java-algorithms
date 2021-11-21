package com.algorithms;

public enum DiscountCode {

    FIVE(5),
    TEN(10),
    FIFTY(50);

    int amount;

    DiscountCode(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
