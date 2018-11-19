package com.myplay.codetest.testenum;

/**
 * @author bh
 * @Description:
 * @Date: 2018/10/11 16:30
 */
public enum NumEnum {
    ZERO("0"),
    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4");
    private String value;


    NumEnum(String value) {
        this.value=value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value=value;
    }
}
