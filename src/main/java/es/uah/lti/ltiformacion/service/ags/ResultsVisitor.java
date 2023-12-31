package es.uah.lti.ltiformacion.service.ags;

import edu.uoc.elc.lti.platform.ags.GenericResultServiceClient;
import edu.uoc.elc.spring.lti.tool.AgsServiceProvider;
import edu.uoc.elc.spring.lti.tool.ToolProvider;
import edu.uoc.lti.ags.Result;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@RequiredArgsConstructor
public class ResultsVisitor {
	private final ToolProvider toolProvider;

	public List<Result> getAll(String id) {
		return getAll(id, null, null, null);
	}

	public List<Result> getAll(String id, Integer limit, Integer page, String userId) {
		final GenericResultServiceClient serviceClient = getServiceClient();
		return serviceClient.getLineItemResults(id, limit, page, userId);
	}

	private GenericResultServiceClient getServiceClient() {
		final AgsServiceProvider agsServiceProvider = toolProvider.getAgsServiceProvider();
		return agsServiceProvider.getResultsServiceClient();
	}
}
