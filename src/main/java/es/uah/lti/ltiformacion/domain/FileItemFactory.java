package es.uah.lti.ltiformacion.domain;

import edu.uoc.lti.deeplink.content.FileItem;
import edu.uoc.lti.deeplink.content.Item;
import es.uah.lti.ltiformacion.beans.DeepLinkForm;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public class FileItemFactory implements ItemFactory {
	@Override
	public Item itemFor(DeepLinkForm deepLinkForm) {
		final FileItem item = FileItem.builder()
						.title(deepLinkForm.getTitle())
						.url(deepLinkForm.getUrl())
						.mediaType(deepLinkForm.getMediaType())
						.build();

		item.setText(deepLinkForm.getText());
		return item;
	}
}
