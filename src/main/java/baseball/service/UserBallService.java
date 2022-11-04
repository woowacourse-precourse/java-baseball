package baseball.service;

import java.util.List;
import java.util.stream.Collectors;

import baseball.domain.UserBall;

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
		for (int i = 0; i < 3; i++) {
			if (userInputList.get(i).equals(answerNumber.get(i))) {
				userBall.changeStrikeCount(userBall.getStrike() + 1);
			}
		}
	}

	private void updateBallCount(List<Integer> answerNumber, List<Integer> userInputList, UserBall userBall) {
		for (int i = 0; i < 3; i++) {
			if (!userInputList.get(i).equals(answerNumber.get(i)) && userInputList.contains(answerNumber.get(i))) {
				userBall.changeBallCount(userBall.getBall() + 1);
			}
		}
	}

}
