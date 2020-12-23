package com.youzhi.tools.bmi.controller;

import com.youzhi.core.component.NumberTextField;
import com.youzhi.core.utils.AlertUtils;
import com.youzhi.tools.bmi.Explanation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * @author: podigua
 * @create: 2020-12-23 14:24
 **/
@Service
public class BmiController implements Initializable {
    private final static List<Explanation> data = Explanation.create();
    @FXML
    public VBox parent;
    @FXML
    public NumberTextField height;
    @FXML
    public NumberTextField weight;
    @FXML
    public VBox rightTopBox;
    @FXML
    public Label value;
    @FXML
    public Label status;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addExplanation();
    }

    /**
     * 添加BMI说明
     */
    private void addExplanation() {
        ObservableList<Node> children = rightTopBox.getChildren();
        Font font = new Font(16);
        data.forEach(item -> {
            HBox box = new HBox();
            box.setStyle("-fx-background-color: " + item.getColor() + ";-fx-padding: 5");
            Label left = createExplanationLabel(item.getType(), font);
            Label right = createExplanationLabel(item.getExplanation(), font);
            box.getChildren().addAll(left, right);
            children.add(box);
        });
    }

    private Label createExplanationLabel(String text, Font font) {
        Label label = new Label(text);
        label.setAlignment(Pos.CENTER);
        label.setFont(font);
        label.setPrefWidth(161);
        return label;
    }

    @FXML
    public void calc(ActionEvent event) {
        boolean isPass = check();
        if (isPass) {
            calc();
        }
    }

    private void calc() {
        BigDecimal heightValue = height.getValue();
        BigDecimal weightValue = weight.getValue();
        BigDecimal hundred = heightValue.divide(new BigDecimal("100"));
        BigDecimal multiply = hundred.multiply(hundred);
        BigDecimal calcValue = weightValue.divide(multiply, 1, RoundingMode.HALF_UP);
        Explanation explanation = getExplanation(calcValue);
        value.setText(calcValue.toString());
        value.setTextFill(Paint.valueOf(explanation.getColor()));
        status.setText(explanation.getType());
        status.setTextFill(Paint.valueOf(explanation.getColor()));
    }

    private Explanation getExplanation(BigDecimal value) {
        for (Explanation explanation : data) {
            boolean isAccord = true;
            if (explanation.getMin() == null && explanation.getMax() == null) {
                continue;
            }
            if (explanation.getMin() != null && value.compareTo(explanation.getMin()) < 0) {
                isAccord = false;
            }
            if (explanation.getMax() != null && value.compareTo(explanation.getMax()) >= 0) {
                isAccord = false;
            }
            if (isAccord) {
                return explanation;
            }
        }
        return null;
    }

    private boolean check() {
        BigDecimal heightValue = height.getValue();
        BigDecimal weightValue = weight.getValue();
        StringBuilder message = new StringBuilder("");
        if (heightValue == null) {
            message.append("请填写身高\n");
        }
        if (weightValue == null) {
            message.append("请填写体重\n");
        }
        if (!StringUtils.isEmpty(message.toString())) {
            AlertUtils.alert(message.toString());
            return false;
        }
        return true;
    }
}
