package es.uah.lti.ltiformacion.domain;

import edu.uoc.lti.deeplink.content.Item;
import es.uah.lti.ltiformacion.beans.DeepLinkForm;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public interface ItemFactory {
	Item itemFor(DeepLinkForm deepLinkForm);
}
