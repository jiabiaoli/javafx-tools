package com.youzhi.core.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: podigua
 * @create: 2020-12-23 21:17
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "tools")
public class ToolsProperties {
    private String title="JavaFX 工具";
}
