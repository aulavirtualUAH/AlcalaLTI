package es.uah.lti.ltiformacion.service;

import edu.uoc.elc.spring.lti.security.Context;
import edu.uoc.elc.spring.lti.security.User;
import edu.uoc.elc.spring.lti.tool.ToolProvider;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public interface MainResolver {
	Object getRecap(User user, ToolProvider toolProvider);
}
