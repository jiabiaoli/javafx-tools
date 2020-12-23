package com.youzhi.core.suppurt.context;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

/**
 * @author: podigua
 * @create: 2020-12-23 11:05
 **/
public class StageReadyEvent extends ApplicationEvent {
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param stage the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public StageReadyEvent(Stage stage) {
        super(stage);
    }

    public Stage getStage(){
        return (Stage) getSource();
    }
}
