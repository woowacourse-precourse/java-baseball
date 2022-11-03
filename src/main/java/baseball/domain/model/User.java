package baseball.domain.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import baseball.utils.InputValidator;

public class User {

	private final List<String> user;

	public User(final List<String> user) {
		this.user = user;
	}

	public User(final String userBallInput) {
		InputValidator.checkUserBallInput(userBallInput);
		this.user = makeUserBallsFromUserInput(userBallInput);
	}

	private List<String> makeUserBallsFromUserInput(final String userBallInput) {
		return new ArrayList<>(Arrays.asList(userBallInput.split("")));
	}

	public Map<BallCount, Integer> compareWithComputerBalls(Computer computer, Map<BallCount, Integer> score) {
		for (String userBall : this.user) {
			BallCount ballCount = computer.compareWithUserBall(userBall, this.user.indexOf(userBall));
			score.put(ballCount, score.get(ballCount) + 1);
		}
		return score;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		User user1 = (User)o;
		return Objects.equals(user, user1.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(user);
	}


}
