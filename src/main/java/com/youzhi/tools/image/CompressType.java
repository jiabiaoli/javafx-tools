package com.youzhi.tools.image;

import lombok.*;

/**
 * @author: podigua
 * @create: 2020-12-24 16:21
 **/
@Getter
public enum CompressType {
    FIX("FIX", "按大小"),
    SCALE("SCALE", "按比例");

    private String value;
    private String label;

    CompressType(String value, String label) {
        this.value = value;
        this.label = label;
    }
}
