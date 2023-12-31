package es.uah.lti.ltiformacion.controllers;

import edu.uoc.elc.spring.lti.tool.ToolProvider;
import es.uah.lti.ltiformacion.service.AgsLineItemDetailResolver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@Controller
@RequestMapping(Paths.AGS_LINEITEM)
@Slf4j
@PreAuthorize("isAuthenticated()")
@RequiredArgsConstructor
public class AgsLineItemDetailController {
	private final AgsLineItemDetailResolver agsLineItemDetailResolver;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index(@RequestParam("id") String id, ToolProvider toolProvider) {
		Object resolvedObject =  agsLineItemDetailResolver.get(id, toolProvider);
		return new ModelAndView("ags/view", "object", resolvedObject);
	}
}
