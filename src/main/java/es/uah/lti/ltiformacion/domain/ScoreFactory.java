package es.uah.lti.ltiformacion.domain;

import edu.uoc.lti.ags.ActivityProgressEnum;
import edu.uoc.lti.ags.GradingProgressEnum;
import edu.uoc.lti.ags.Score;

import java.time.Instant;

/**
 * @author antoni@tresipunt.com based on xaracil@uoc.edu
 */
public class ScoreFactory {
	public Score from(String userId, Double score, String comment) {
		return Score.builder()
						.userId(userId)
						.scoreGiven(score)
						.comment(comment)
						.timestamp(Instant.now())
						.activityProgress(ActivityProgressEnum.COMPLETED)
						.gradingProgress(GradingProgressEnum.FULLY_GRADED)
						.build();
	}
}
