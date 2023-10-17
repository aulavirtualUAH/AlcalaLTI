package es.uah.lti.ltiformacion.service.ags;

import edu.uoc.elc.lti.platform.ags.GenericScoreServiceClient;
import edu.uoc.elc.spring.lti.tool.AgsServiceProvider;
import edu.uoc.elc.spring.lti.tool.ToolProvider;
import edu.uoc.lti.ags.Score;
import lombok.RequiredArgsConstructor;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@RequiredArgsConstructor
public class ScoreVisitor {
	private final ToolProvider toolProvider;

	public boolean score(String id, Score score) {
		final GenericScoreServiceClient serviceClient = getServiceClient();
		return serviceClient.score(id, score);
	}

	private GenericScoreServiceClient getServiceClient() {
		final AgsServiceProvider agsServiceProvider = toolProvider.getAgsServiceProvider();
		return agsServiceProvider.getScoreServiceClient();
	}
}
