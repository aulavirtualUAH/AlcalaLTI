package es.uah.lti.ltiformacion.controllers;

import edu.uoc.elc.lti.tool.Registration;
import edu.uoc.elc.spring.lti.tool.registration.RegistrationService;
import es.uah.lti.ltiformacion.beans.LmsTool;
import es.uah.lti.ltiformacion.components.jwtkeystore.KeySetManager;
import es.uah.lti.ltiformacion.components.toolmanager.ToolManager;
import es.uah.lti.ltiformacion.utils.Paths;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class KeySetController {

    private final ToolManager toolManager;
    private final KeySetManager keySetManager;
    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private RegistrationService registrationService;


    public KeySetController(ToolManager toolManager, KeySetManager keySetManager) {
        this.toolManager = toolManager;
        this.keySetManager = keySetManager;
    }

    @RequestMapping(value = Paths.KEYSET, method = RequestMethod.GET)
    @ResponseBody
    public String getKeySet(HttpServletRequest request) {
        LmsTool tool = toolManager.getToolById("1");
        JSONObject keySetJson = keySetManager.getKeySet(tool);
        return keySetJson.toJSONString();
    }
    @RequestMapping(value = Paths.KEYSETID, method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getKeySetById(@PathVariable String id) {
        final Registration registration =  registrationService.getRegistration(id);
        JSONObject keySetJson = keySetManager.getKeySet(registration);
        return keySetJson;
    }
}