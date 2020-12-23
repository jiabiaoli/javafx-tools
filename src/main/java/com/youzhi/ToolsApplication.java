package com.youzhi;

import com.youzhi.core.ToolsContext;
import com.youzhi.core.suppurt.context.StageReadyEvent;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.math.BigDecimal;


/**
 * @author podigua
 */
@SpringBootApplication
public class ToolsApplication extends Application {
    public static void main(String[] args) {
        Application.launch(ToolsApplication.class, args);
    }

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() throws Exception {
        applicationContext = new SpringApplicationBuilder(ToolsApplication.class).run();
    }

    @Override
    public void stop() throws Exception {
        applicationContext.close();
        Platform.exit();
    }

    @Override
    public void start(Stage stage) throws Exception {
        ToolsContext.stage(stage);
        applicationContext.publishEvent(new StageReadyEvent(stage));
    }
}
