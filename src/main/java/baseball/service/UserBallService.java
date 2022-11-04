package baseball.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import baseball.domain.UserBall;
import baseball.util.ViewConst;

public class UserBallService {

	public UserBall makeUserBall(String userInput, List<Integer> answerNumber) {
		List<Integer> userInputList = userInput.chars()
			.mapToObj(num -> Integer.parseInt(num + "") - 48)
			.collect(Collectors.toList());

		UserBall userBall = UserBall.createUserBall();
		updateBallCount(answerNumber, userInputList, userBall);
		updateStrikeCount(answerNumber, userInputList, userBall);
		return userBall;
	}

	private void updateStrikeCount(List<Integer> answerNumber, List<Integer> userInputList, UserBall userBall) {
		int strikeCount = (int)IntStream.iterate(0, i -> i + 1)
			.limit(ViewConst.INPUT_NUM_LENGTH)
			.filter(i -> userInputList.get(i).equals(answerNumber.get(i)))
			.count();
		userBall.changeStrikeCount(userBall.getStrike() + strikeCount);

	}

	private void updateBallCount(List<Integer> answerNumber, List<Integer> userInputList, UserBall userBall) {
		int ballCount = (int)IntStream.iterate(0, i -> i + 1)
			.limit(ViewConst.INPUT_NUM_LENGTH)
			.filter(
				i -> !userInputList.get(i).equals(answerNumber.get(i)) && userInputList.contains(answerNumber.get(i)))
			.count();
		userBall.changeBallCount(userBall.getBall() + ballCount);
	}

}
