package com.youzhi.tools.bmi;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 说明
 *
 * @author: podigua
 * @create: 2020-12-23 17:16
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Explanation {
    private String type;
    private String color;
    private String explanation;
    private BigDecimal min;
    private BigDecimal max;

    public Explanation(String type, String color, String explanation) {
        this.type = type;
        this.color = color;
        this.explanation = explanation;
    }

    public static List<Explanation> create() {
        List<Explanation> result = new ArrayList<>();
        result.add(Explanation.builder().type("分类").color("#70A7E3").explanation("BMI 范围").build());
        result.add(Explanation.builder().type("偏瘦").color("#999999").explanation("<= 18.4").min(BigDecimal.ZERO).max(new BigDecimal("18.4")).build());
        result.add(Explanation.builder().type("正常").color("#499011").explanation("18.5 ~ 23.9").min(new BigDecimal("18.5")).max(new BigDecimal("23.9")).build());
        result.add(Explanation.builder().type("过重").color("#EEF420").explanation("24.0 ~ 27.9").min(new BigDecimal("24.0")).max(new BigDecimal("27.9")).build());
        result.add(Explanation.builder().type("肥胖").color("#AD5A0E").explanation(">= 28.0").min(new BigDecimal("28.0")).max(null).build());
        return result;
    }
}
