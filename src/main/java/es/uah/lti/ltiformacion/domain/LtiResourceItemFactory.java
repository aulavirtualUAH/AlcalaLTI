package es.uah.lti.ltiformacion.domain;

import edu.uoc.lti.deeplink.content.*;
import es.uah.lti.ltiformacion.beans.DeepLinkForm;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public class LtiResourceItemFactory implements ItemFactory {
	@Override
	public Item itemFor(DeepLinkForm deepLinkForm) {
		LtiResourceItem item = LtiResourceItem.builder()
						.title(deepLinkForm.getTitle())
						.url(deepLinkForm.getUrl())
						.build();

		item = setDocumentTarget(deepLinkForm.getDocumentTarget(), item);

		return item;
	}

	private LtiResourceItem setDocumentTarget(String documentTarget, LtiResourceItem item) {
		final DocumentTargetEnum documentTargetEnum = DocumentTargetEnum.valueOf(documentTarget);
		if (documentTargetEnum == DocumentTargetEnum.iframe) {
			item.setIFrame(IFrame.builder()
							.url(item.getUrl())
							.build());
		}
		if (documentTargetEnum == DocumentTargetEnum.window) {
			item.setWindow(Window.builder().build());
		}
		return item;
	}
}
