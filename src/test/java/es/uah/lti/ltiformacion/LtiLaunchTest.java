package es.uah.lti.ltiformacion;

import es.uah.lti.ltiformacion.controllers.MainController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class LtiLaunchTest {

    @Autowired
    private MainController controller;

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    /**
     * Test that the spring application context is loaded properly
     */
    @Test
    public void contextLoads() {
        Assertions.assertNotNull(controller);
    }

    @Test
    public void ltiLaunch() {
        oidcLaunch();
    }

    /**
     * Request to proxy for oidc launch
     */
    private void oidcLaunch() {
        String servletContext = "lti13-test";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
        requestParams.add("iss", "https://moodle.3ip.eu");
        requestParams.add("target_link_uri", "http://localhost:" + port + "/" + servletContext);
        requestParams.add("login_hint", "89");
        requestParams.add("lti_message_hint", "226");
        requestParams.add("lti_deployment_id", "6");
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(requestParams, headers);
        ResponseEntity<String> response = this.restTemplate.postForEntity(
                "http://localhost:" + port + "/" + servletContext + "/oidclaunch",
                request, String.class);
        Assertions.assertNotNull(response);
    }


}
