package es.uah.lti.ltiformacion.config;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.SameSiteCookies;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Unversidad de Alcalá
 * @author Antoni Bertran (antoni@tresipunt.com)
 * Made for the project ListadoAlumnosLTI
 */
@Component
@RequiredArgsConstructor
public class TomcatConfig implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {
    private final Environment environment;

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        if (factory instanceof TomcatServletWebServerFactory) {
            TomcatServletWebServerFactory tomcatServletWebServerFactory = (TomcatServletWebServerFactory) factory;
            if (!Arrays.asList(environment.getActiveProfiles()).contains("devel")) {
                tomcatServletWebServerFactory.addConnectorCustomizers(connector -> {
                    connector.setProxyPort(443);
                    connector.setScheme("https");
                });
                tomcatServletWebServerFactory.addContextCustomizers(context -> {
                    CustomCookieProcessor cookieProcessor = new CustomCookieProcessor();
                    cookieProcessor.setSameSiteCookies(SameSiteCookies.NONE.getValue());
                    context.setCookieProcessor(cookieProcessor);
                    context.setUseHttpOnly(false);
                });
            }
        }
    }
}
