package com.youzhi.tools;

import com.youzhi.core.ToolsContext;
import com.youzhi.core.service.FxmlService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.tools.Tool;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author: podigua
 * @create: 2020-12-23 10:59
 **/
@Service
public class IndexController implements Initializable {
    private final FxmlService fxmlService;

    public IndexController(FxmlService fxmlService) {
        this.fxmlService = fxmlService;
    }

    @FXML
    public VBox parent;
    @FXML
    public TabPane pane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToolsContext.tab(pane);
    }

    public void open(ActionEvent event) throws IOException {
        fxmlService.add2Tab("Text","fxml/main.fxml");
    }

    public void bmi(ActionEvent event) {
        fxmlService.add2Tab("身体质量指数","fxml/bmi/bmi.fxml");
    }
}
