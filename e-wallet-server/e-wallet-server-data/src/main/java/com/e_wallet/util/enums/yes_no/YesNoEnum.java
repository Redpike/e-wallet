package com.e_wallet.util.enums.yes_no;

/**
 * Created by Redpike
 */
public enum YesNoEnum {

    YES("y"),
    NO("n");

    private String databaseValue;

    YesNoEnum(String databaseValue) {
        this.databaseValue = databaseValue;
    }

    public String getDatabaseValue() {
        return databaseValue;
    }

    @Override
    public String toString() {
        return "YesNoEnum{" +
                "databaseValue='" + databaseValue + '\'' +
                '}';
    }
}
