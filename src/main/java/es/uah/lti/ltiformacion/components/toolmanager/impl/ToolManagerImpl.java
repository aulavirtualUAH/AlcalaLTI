package es.uah.lti.ltiformacion.components.toolmanager.impl;

import es.uah.lti.ltiformacion.beans.LmsTool;
import es.uah.lti.ltiformacion.components.toolmanager.ToolManager;
import es.uah.lti.ltiformacion.config.ToolsConfig;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component("toolManager")
public class ToolManagerImpl implements ToolManager {
	
	private final ToolsConfig toolsConfigProperties;

    ToolManagerImpl(ToolsConfig toolsConfigProperties) {
    	this.toolsConfigProperties = toolsConfigProperties;
    }


    @Override
    public LmsTool getToolById(String id) {
    	LmsTool tool = toolsConfigProperties.getToolConfig().get(id);
    	tool.setId(id);
    	
    	return tool;
    }

    @Override
    public LmsTool getToolByClientId(String clientId) {
		return toolsConfigProperties.getToolConfig().values()
			.stream()
			.filter(itTool -> itTool.getClientId().equals(clientId))
			.findFirst()
			.orElse(null);
    }
}
