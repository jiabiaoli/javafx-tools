package com.youzhi.core.component;


import javafx.scene.control.IndexRange;
import javafx.scene.control.TextField;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;

/**
 * 自定义组件(数字框)正
 *
 * @author: podigua
 * @create: 2020-12-23 14:25
 **/
public class NumberTextField extends TextField {
    private static final String POINT = ".";

    @Override
    public void replaceText(int start, int end, String text) {
        if (validate(text)) {
            super.replaceText(start, end, text);
            reset();
        }
    }

    private void reset() {
        if (getText().startsWith(POINT)) {
            setText("0" + getText());
            positionCaret(getText().length());
        }
    }

    /**
     * 获取值
     *
     * @return
     */
    public BigDecimal getValue() {
        String text = super.getText();
        if (!StringUtils.isEmpty(text)) {
            return new BigDecimal(text);
        }
        return null;
    }


    @Override
    public void replaceSelection(String text) {
        if (validate(text)) {
            super.replaceSelection(text);
            reset();
        }
    }

    private boolean validate(String text) {
        if (StringUtils.isEmpty(text)) {
            return true;
        }
        boolean isNumber = text.matches("[0-9]*");
        IndexRange selection = getSelection();
        int length = selection.getLength();
        boolean isPoint = false;
        if (length == 0) {
            isPoint = text.matches("\\.") && !getText().contains(".");
        } else {
            isPoint = text.matches("\\.") && getSelectedText().contains(".");
        }
        return isNumber || isPoint;
    }

}
