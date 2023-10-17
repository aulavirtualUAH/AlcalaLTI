package es.uah.lti.ltiformacion.domain;

import edu.uoc.lti.ags.LineItem;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public class LineItemFactory {
	public LineItem newLineItem(String label, Double maxScore, String tag) {
		final LineItem lineItem = new LineItem();
		lineItem.setLabel(label);
		lineItem.setScoreMaximum(maxScore);
		lineItem.setTag(tag);
		return lineItem;
	}
}
