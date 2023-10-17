package es.uah.lti.ltiformacion.service;

import edu.uoc.elc.spring.lti.tool.ToolProvider;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public interface AgsLineItemsResolver {
	Object list(ToolProvider toolProvider, String tag);
	void createLineItem(String label, Double maxScore, ToolProvider toolProvider, String tag);
}
