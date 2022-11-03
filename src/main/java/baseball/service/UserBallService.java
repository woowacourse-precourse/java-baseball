package baseball.service;

import java.util.List;
import java.util.stream.Collectors;

import baseball.domain.UserBall;

public class UserBallService {

	//Todo: 정답 체크
	public boolean isAnswer(String userInput, List<Integer> answerNumber) {

	}

	//Todo: userball 만들기
	private UserBall makeUserBall(String userInput, List<Integer> answerNumber) {
		List<Integer> userInputList = userInput.chars()
			.mapToObj(num -> Integer.parseInt(num + "") - 48)
			.collect(Collectors.toList());

		UserBall userBall = new UserBall(0, 0);

		/**
		 * ball count 갱신
		 */
		for (int i = 0; i < 3; i++) {
			if (!userInputList.get(i).equals(answerNumber.get(i)) && userInputList.contains(answerNumber.get(i))) {
				userBall.changeBallCount(userBall.getBall() + 1);
			}
		}

		/**
		 * strike count 갱신
		 */
		for (int i = 0; i < 3; i++) {
			if (userInputList.get(i).equals(answerNumber.get(i))) {
				userBall.changeStrikeCount(userBall.getStrike() + 1);
			}
		}

		return userBall;

	}

}
