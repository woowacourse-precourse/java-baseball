package baseball.domain.model;

import java.util.Map;

public class Score {
	private final Map<BallCount, Integer> score;

	public Score(Map<BallCount, Integer> score) {
		this.score = score;
	}
}
