package com.youzhi.tools.image.controller;

import com.youzhi.tools.image.CompressType;
import com.youzhi.tools.image.converter.CompressTypeConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author: podigua
 * @create: 2020-12-23 21:49
 **/
@Service
public class CompressController implements Initializable {
    private final ObservableList<CompressType> types = FXCollections.observableArrayList(
            CompressType.FIX, CompressType.SCALE
    );
    @FXML
    public ChoiceBox<CompressType> compressType;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        compressType.setValue(CompressType.FIX);
        compressType.setConverter(new CompressTypeConverter());
        compressType.setItems(types);
        compressType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

        });
    }

    public void test(ActionEvent event) {
        CompressType value = compressType.getValue();
        System.out.println(value);

    }
}
