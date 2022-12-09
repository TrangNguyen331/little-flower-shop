package com.thuytrang.littleflowershop.model;

public enum EColor {
    WHITE("Trắng"),
    PINK("Hồng"),
    RED("Đỏ"),
    GREEN("Xanh lá"),
    BLUE("Xanh dương");

    private final String displayValue;

    private EColor(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }
}