package es.uah.lti.ltiformacion.domain;

import edu.uoc.lti.deeplink.content.HtmlItem;
import edu.uoc.lti.deeplink.content.Item;
import es.uah.lti.ltiformacion.beans.DeepLinkForm;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public class HtmlItemFactory implements ItemFactory {
	@Override
	public Item itemFor(DeepLinkForm deepLinkForm) {
		return HtmlItem.builder()
						.html(deepLinkForm.getUrl())
						.text(deepLinkForm.getText())
						.title(deepLinkForm.getTitle())
						.build();
	}
}
