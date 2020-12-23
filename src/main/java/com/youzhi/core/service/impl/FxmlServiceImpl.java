package com.youzhi.core.service.impl;

import com.youzhi.core.ToolsContext;
import com.youzhi.core.service.FxmlService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Region;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

/**
 * @author: podigua
 * @create: 2020-12-23 14:03
 **/
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class FxmlServiceImpl implements FxmlService {
    private final ApplicationContext applicationContext;

    @SneakyThrows
    @Override
    public Parent getByPath(String path) {
        FXMLLoader loader = new FXMLLoader(new ClassPathResource(path).getURL());
        loader.setControllerFactory(clazz -> applicationContext.getBean(clazz));
        return loader.load();
    }

    @Override
    public void add2Tab(String text, String path) {
        assert text != null;
        TabPane pane = ToolsContext.tab();
        for (Tab tab : pane.getTabs()) {
            if (text.equals(tab.getText())) {
                pane.getSelectionModel().select(tab);
                return;
            }
        }
        Parent parent = getByPath(path);
        Tab tab = new Tab(text);
        tab.setContent(parent);
        pane.getTabs().add(tab);
        pane.getSelectionModel().select(tab);
        pane.widthProperty().addListener((number)->{
            System.out.println("number :" +number);
        });
        if(parent instanceof Region){
            ((Region) parent).prefWidthProperty().bind(pane.widthProperty());
            ((Region) parent).prefHeightProperty().bind(pane.heightProperty());
        }

    }
}
