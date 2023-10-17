package es.uah.lti.ltiformacion.service;

import es.uah.lti.ltiformacion.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Locale;

/**
 * @author antoni@tresipunt.com
 */
@Slf4j
@Service
public class LTILocaleResolverImpl implements LTILocaleResolver {
    private static final String DEFAULT_COUNTRY = "US";
    @Value("${listadoalumnos.lti.languages.supported}")
    private String[] supportedLanguages;
    @Value("${listadoalumnos.lti.default.language}")
    private String defaultLang;

    @Override
    public Locale getLocale(String locale) {
        String country = DEFAULT_COUNTRY;
        String langRA = defaultLang;
        if (locale != null) {
            final String lang = Utils.getLang(locale);
            langRA = lang;
            if (supportedLanguages != null && !Arrays.stream(Arrays.stream(supportedLanguages).toArray()).sequential().anyMatch(s -> lang.equals(s))) {
                langRA = defaultLang;
            }
            try {
                Locale lc = Locale.forLanguageTag(langRA);
                if (lc != null) {
                    country = lc.getCountry();
                    langRA = lc.getLanguage();
                }
            } catch (Exception e) {
                country = DEFAULT_COUNTRY;
            }
        }

        return new Locale(langRA, country);
    }

}
