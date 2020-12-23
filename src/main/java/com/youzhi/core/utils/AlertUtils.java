package com.youzhi.core.utils;

import com.youzhi.core.ToolsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * @author: podigua
 * @create: 2020-12-23 17:54
 **/
public class AlertUtils {
    /**
     * 信息提示
     * @param message
     */
    public static void alert(String message) {
        Alert alert = new Alert(Alert.AlertType.NONE, message, ButtonType.OK);
        alert.setTitle("信息提示");
        alert.initOwner(ToolsContext.stage());
        alert.showAndWait();
    }
}
