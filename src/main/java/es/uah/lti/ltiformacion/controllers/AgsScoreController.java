package es.uah.lti.ltiformacion.controllers;

import edu.uoc.elc.spring.lti.tool.ToolProvider;
import edu.uoc.lti.ags.Score;
import es.uah.lti.ltiformacion.domain.ScoreFactory;
import es.uah.lti.ltiformacion.service.ags.ScoreVisitor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
@Controller
@RequestMapping(Paths.AGS_LINEITEM_SCORE)
@Slf4j
@PreAuthorize("isAuthenticated()")
public class AgsScoreController {

	@RequestMapping(method = RequestMethod.POST)
	public String score(@RequestParam("id") String id, String userId, Double score, String comment, ToolProvider toolProvider) {
		final Score scoreObject = createScoreObject(userId, score, comment);
		final boolean scored = saveScoreInPlatform(id, scoreObject, toolProvider);
		if (!scored) {
			throw new RuntimeException("Scored failed!!!");
		}
		return "redirect:/ags/lineitems?id=" + id;
	}

	private Score createScoreObject(String userId, Double score, String comment) {
		ScoreFactory scoreFactory = new ScoreFactory();
		return scoreFactory.from(userId, score, comment);
	}

	private boolean saveScoreInPlatform(String id, Score score, ToolProvider toolProvider) {
		final ScoreVisitor scoreVisitor = new ScoreVisitor(toolProvider);
		return scoreVisitor.score(id, score);
	}

}
