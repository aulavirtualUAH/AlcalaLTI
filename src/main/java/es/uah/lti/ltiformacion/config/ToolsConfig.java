package es.uah.lti.ltiformacion.config;

import es.uah.lti.ltiformacion.beans.LmsTool;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@PropertySource(value = "classpath:tools.properties")
@ConfigurationProperties(prefix = "tools")
public class ToolsConfig {

    private Map<String, LmsTool> toolConfig;

    public Map<String, LmsTool> getToolConfig() {
        return toolConfig;
    }

    public void setToolConfig(Map<String, LmsTool> toolConfig) {
        this.toolConfig = toolConfig;
    }
}
