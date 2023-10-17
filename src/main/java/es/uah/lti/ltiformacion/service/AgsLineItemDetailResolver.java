package es.uah.lti.ltiformacion.service;

import edu.uoc.elc.spring.lti.tool.ToolProvider;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public interface AgsLineItemDetailResolver {
	Object get(String id, ToolProvider toolProvider);
}
