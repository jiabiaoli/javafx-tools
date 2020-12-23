package com.youzhi.core.service;

import javafx.scene.Parent;

/**
 * @author: podigua
 * @create: 2020-12-23 13:59
 **/
public interface FxmlService {
    /**
     * 路径
     *
     * @param path
     * @return
     */
    Parent getByPath(String path);

    /**
     * 添加到tab
     *
     * @param text
     * @param path
     */
    void add2Tab(String text, String path);
}
