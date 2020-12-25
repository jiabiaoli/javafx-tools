package com.youzhi.tools.image.converter;

import com.youzhi.tools.image.CompressType;
import javafx.util.StringConverter;

/**
 * @author: podigua
 * @create: 2020-12-24 16:37
 **/
public class CompressTypeConverter extends StringConverter<CompressType> {
    @Override
    public String toString(CompressType type) {
        return type.getLabel();
    }

    @Override
    public CompressType fromString(String string) {
        return CompressType.valueOf(string);
    }
}
