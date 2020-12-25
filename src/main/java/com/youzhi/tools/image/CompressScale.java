package com.youzhi.tools.image;

import lombok.Getter;

/**
 * @author: podigua
 * @create: 2020-12-24 16:21
 **/
@Getter
public enum CompressScale {
    ONE("1", "1"),
    FIVE("5", "5"),
    TEN("10", "10"),
    TWENTY("20", "10");

    private String value;
    private String label;

    CompressScale(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
