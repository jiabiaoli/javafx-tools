package com.youzhi.core.suppurt.context;

import com.youzhi.core.ToolsContext;
import com.youzhi.core.service.FxmlService;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author: podigua
 * @create: 2020-12-23 11:06
 **/
@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StageReadyListener implements ApplicationListener<StageReadyEvent> {
    private final static String FXML_INDEX = "fxml/index.fxml";
    private final FxmlService fxmlService;

    @SneakyThrows
    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        stage.setScene(new Scene(fxmlService.getByPath(FXML_INDEX)));
        stage.setWidth(800);
        stage.setHeight(600);
        stage.show();
        ToolsContext.stage(stage);
    }
}
