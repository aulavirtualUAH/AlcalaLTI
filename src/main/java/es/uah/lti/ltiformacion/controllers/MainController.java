package es.uah.lti.ltiformacion.controllers;

import edu.uoc.elc.spring.lti.security.User;
import edu.uoc.elc.spring.lti.tool.ToolProvider;
import es.uah.lti.ltiformacion.service.LTILocaleResolver;
import es.uah.lti.ltiformacion.service.MainResolver;
import es.uah.lti.ltiformacion.utils.Paths;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Unversidad de Alcalá
 * @author Antoni Bertran (antoni@tresipunt.com)
 * Made for the project ListadoAlumnosLTI
 */
@Controller
@Slf4j
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
public class MainController {
    private final LocaleResolver localeResolver;
    private final LTILocaleResolver ltiLocaleResolver;
    private final MainResolver mainResolver;
    @Value("${listadoalumnos.host}")
    private String host;
    @Value(Paths.MAIN)
    private String contextpath;
    @Autowired
    private MessageSource messageSource;


    private void setLocalePage(String locale, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        localeResolver.setLocale(httpServletRequest, httpServletResponse, ltiLocaleResolver.getLocale(locale));
    }

    @RequestMapping(path = {Paths.MAIN}, method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView init(User user, ToolProvider toolProvider, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, URISyntaxException {

        setLocalePage(user.getTool().getLocale(), httpServletRequest, httpServletResponse);

        final Object response = mainResolver.getRecap(user, toolProvider);
        return new ModelAndView("index.html", "object", response);

    }

}