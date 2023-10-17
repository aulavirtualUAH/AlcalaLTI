package es.uah.lti.ltiformacion.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.Rfc6265CookieProcessor;
import org.apache.tomcat.util.http.SameSiteCookies;

import javax.servlet.http.Cookie;

/**
 * Unversidad de Alcalá
 * Made for the project lti 1.3 proxy
 */
@Slf4j
public class CustomCookieProcessor extends Rfc6265CookieProcessor {

    @Override
    public String generateHeader(Cookie cookie) {

        final StringBuilder header = new StringBuilder(super.generateHeader(cookie));

            SameSiteCookies sameSiteCookiesValue = this.getSameSiteCookies();
            if (sameSiteCookiesValue.equals(SameSiteCookies.NONE)) {
                header.append("; SameSite=");
                header.append(sameSiteCookiesValue.getValue());
            }
        return header.toString();
    }
}
