package es.uah.lti.ltiformacion.service;

import edu.uoc.elc.spring.lti.tool.ToolProvider;
import edu.uoc.lti.ags.LineItem;
import es.uah.lti.ltiformacion.beans.AgsBean;
import es.uah.lti.ltiformacion.domain.LineItemFactory;
import es.uah.lti.ltiformacion.service.ags.LineItemVisitor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@Service
public class AgsLineItemsResolverImpl implements AgsLineItemsResolver {

	@Override
	public AgsBean list(ToolProvider toolProvider, String tag) {
		final List<LineItem> lineItems = getExistingLineItemsForTool(toolProvider, tag);
		return new AgsBean(true, lineItems);
	}

	private List<LineItem> getExistingLineItemsForTool(ToolProvider toolProvider, String tag) {
		LineItemVisitor lineItemVisitor = new LineItemVisitor(toolProvider);
		return lineItemVisitor.getAll(null, null, tag, null);
	}

	@Override
	public void createLineItem(String label, Double maxScore, ToolProvider toolProvider, String tag) {
		final LineItem lineItem = createObject(label, maxScore, tag);
		saveInPlatform(lineItem, toolProvider);
	}

	private LineItem createObject(String label, Double maxScore, String tag) {
		LineItemFactory lineItemFactory = new LineItemFactory();
		return lineItemFactory.newLineItem(label, maxScore, tag);
	}

	private LineItem saveInPlatform(LineItem lineItem, ToolProvider toolProvider) {
		LineItemVisitor lineItemVisitor = new LineItemVisitor(toolProvider);
		return lineItemVisitor.create(lineItem);
	}
}
