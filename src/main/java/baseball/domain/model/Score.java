package baseball.domain.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class Score {
	private Map<BallCount, Integer> score;

	public Score() {
		this.score = intiScoreMap();
	}

	public Score(Map<BallCount, Integer> score) {
		this.score = score;
	}

	public Score(Computer computer, User user) {
		this.score = calculateBallCountScore(computer, user);
	}

	private Map<BallCount, Integer> intiScoreMap() {
		return Arrays.stream(BallCount.values())
			.collect(Collectors.toMap(value -> value, count -> 0, (a, b) -> b, () -> new EnumMap<>(BallCount.class)));
	}

	private Map<BallCount, Integer> calculateBallCountScore(Computer computer, User user) {
		return user.compareWithComputerBalls(computer, intiScoreMap());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Score score1 = (Score)o;
		return Objects.equals(score, score1.score);
	}

	@Override
	public int hashCode() {
		return Objects.hash(score);
	}

	@Override
	public String toString() {
		return "Score{" +
			"score=" + score +
			'}';
	}
}
