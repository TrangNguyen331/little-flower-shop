package com.thuytrang.littleflowershop.model;

public enum EColor {
    WHITE("Trắng"),
    PINK("Hồng"),
    VIOLET("Tím"),
    YELLOW("Vàng"),
    ORANGE("Cam"),
    RED("Đỏ"),
    GREEN("Xanh lá"),
    BLUE("Xanh dương");

    private final String displayValue;

    EColor(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}