package com.youzhi.core;

import javafx.scene.control.TabPane;
import javafx.stage.Stage;

/**
 * @author: podigua
 * @create: 2020-12-23 13:59
 **/
public class ToolsContext {
    private static Stage STAGE;
    private static TabPane TAB_PANE;

    /**
     * 获取 stage
     *
     * @return
     */
    public static Stage stage() {
        return STAGE;
    }

    /**
     * 设置stage
     *
     * @param stage
     */
    public static void stage(Stage stage) {
        STAGE = stage;
    }

    /**
     * 设置tab_pane
     *
     * @param tabPane
     */
    public static void tab(TabPane tabPane) {
        TAB_PANE = tabPane;
    }

    /**
     * 获取tab_pane
     *
     * @return
     */
    public static TabPane tab() {
        return TAB_PANE;
    }
}
