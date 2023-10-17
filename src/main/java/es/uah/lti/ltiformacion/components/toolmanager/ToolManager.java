package es.uah.lti.ltiformacion.components.toolmanager;


import es.uah.lti.ltiformacion.beans.LmsTool;

public interface ToolManager {

    /**
     *
     * @param id
     * @return
     */
    LmsTool getToolById(String id);

    /**
     *
     * @param id
     * @return
     */
    LmsTool getToolByClientId(String id);
}
