package com.example.springboot.persistence.entity.enums;

import java.math.BigDecimal;

public enum DeveloperLevelEnum {
    TRAINEE(new BigDecimal("2100.00")),
    JUNIOR(new BigDecimal("3200")),
    MID(new BigDecimal("4500")),
    SENIOR(new BigDecimal("7000")),
    LEADER(new BigDecimal("12000"));

    private final BigDecimal salary;

    DeveloperLevelEnum(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return this.salary;
    }

    public DeveloperLevelEnum getNewLevel() {
        return switch (this) {
            case TRAINEE -> JUNIOR;
            case JUNIOR -> MID;
            case MID -> SENIOR;
            case SENIOR -> LEADER;
            default -> this;
        };
    }
}