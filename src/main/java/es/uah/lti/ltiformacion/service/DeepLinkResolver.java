package es.uah.lti.ltiformacion.service;

import edu.uoc.elc.spring.lti.tool.ToolProvider;
import es.uah.lti.ltiformacion.beans.DeepLinkBean;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public interface DeepLinkResolver {
	Object getMainInfo(ToolProvider toolProvider);
	Object addItem(DeepLinkBean deepLinkBean, ToolProvider toolProvider);
	Object removeItemAt(DeepLinkBean deepLinkBean, Integer index, ToolProvider toolProvider);
	Object save(DeepLinkBean deepLinkBean, ToolProvider toolProvider);
}
