package com.youzhi.core.suppurt.context;

import com.youzhi.core.properties.ToolsProperties;
import com.youzhi.core.service.FxmlService;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.ClassPathResource;
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
    private final ToolsProperties toolsProperties;

    @SneakyThrows
    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.getStage();
        stage.setScene(new Scene(fxmlService.getByPath(FXML_INDEX),800,600));
        Image image = new Image(new ClassPathResource("images/logo.png").getInputStream());
        stage.getIcons().add(image);
        stage.setTitle(toolsProperties.getTitle());
        stage.sizeToScene();
        stage.show();

    }
}
