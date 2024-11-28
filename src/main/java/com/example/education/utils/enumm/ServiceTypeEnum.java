package com.example.education.utils.enumm;

public enum ServiceTypeEnum {
    LAUNDRY(1),
    PARKING(2),
    EATING(3);

    private final int value;

    ServiceTypeEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ServiceTypeEnum fromValue(int value) {
        for (ServiceTypeEnum serviceType : ServiceTypeEnum.values()) {
            if (serviceType.getValue() == value) {
                return serviceType;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
