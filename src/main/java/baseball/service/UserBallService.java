package baseball.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import baseball.domain.UserBall;
import baseball.util.ViewConst;

public class UserBallService {

	public UserBall makeUserBall(String userInputNumber, List<Integer> answerNumber) {
		List<Integer> userInputNumList = userInputNumber.chars()
			.mapToObj(num -> Integer.parseInt(num + "") - 48)
			.collect(Collectors.toList());

		UserBall userBall = UserBall.createUserBall();
		updateBallCount(answerNumber, userInputNumList, userBall);
		updateStrikeCount(answerNumber, userInputNumList, userBall);

		userBall.updateStatus();
		return userBall;
	}

	private void updateStrikeCount(List<Integer> answerNumber, List<Integer> userInputNumList, UserBall userBall) {
		int strikeCount = (int)IntStream.iterate(0, i -> i + 1)
			.limit(ViewConst.INPUT_NUM_LENGTH)
			.filter(i -> userInputNumList.get(i).equals(answerNumber.get(i)))
			.count();
		userBall.updateStrikeCount(userBall.getStrike() + strikeCount);
	}

	private void updateBallCount(List<Integer> answerNumber, List<Integer> userInputNumList, UserBall userBall) {
		int ballCount = (int)IntStream.iterate(0, i -> i + 1)
			.limit(ViewConst.INPUT_NUM_LENGTH)
			.filter(i -> !userInputNumList.get(i).equals(answerNumber.get(i)) && userInputNumList.contains(
				answerNumber.get(i)))
			.count();
		userBall.updateBallCount(userBall.getBall() + ballCount);
	}

}
