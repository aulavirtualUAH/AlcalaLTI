package es.uah.lti.ltiformacion.controllers;

import edu.uoc.elc.spring.lti.tool.registration.DeploymentBean;
import edu.uoc.elc.spring.lti.tool.registration.RegistrationBean;
import es.uah.lti.ltiformacion.utils.Paths;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(Paths.HEALTH)
@ConfigurationProperties(prefix = "lti.basic")
@Getter
@Setter
public class HealthController {


    private List<RegistrationBean> registrationBean;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String getKeySet(HttpServletRequest request) {
        // TODO
        // return keySetJson != null ? "OK" : "Error";
        return "OK";
    }

    @RequestMapping(method = RequestMethod.GET, value = Paths.CONFIGURE)
    @ResponseBody
    public String getConfigurationInfo(HttpServletRequest request) {
        StringBuffer str = new StringBuffer();
        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            str.append("<br> " + key + "=" + env.get(key));
        }

        if (registrationBean != null)
            for (RegistrationBean registration : registrationBean) {
                str.append("<br>key-set-url=" + registration.getKeySetUrl());
                str.append("<br> access-token-url=" + registration.getAccessTokenUrl());
                str.append("<br> oidc-auth-url=" + registration.getOidcAuthUrl());
                str.append("<br> platform=" + registration.getPlatform());
                str.append("<br> client-id=" + registration.getClientId());
                for (DeploymentBean deployment : registration.getDeployments()) {
                    str.append(" deployment-id=" + deployment.getDeploymentId());
                }
            }

        return str.toString();
    }

}
