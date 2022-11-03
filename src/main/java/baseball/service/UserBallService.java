package baseball.service;

import java.util.List;
import java.util.stream.Collectors;

import baseball.domain.UserBall;
import baseball.view.InputView;
import baseball.view.OutputView;

public class UserBallService {

	private final OutputView outputView;
	private final InputView inputView;

	public UserBallService(OutputView outputView, InputView inputView) {
		this.outputView = outputView;
		this.inputView = inputView;
	}

	//Todo: 정답 체크
	public boolean isAnswer(String userInput, List<Integer> answerNumber) {
		UserBall userBall = makeUserBall(userInput, answerNumber);

		if (userBall.getStrike() == 3) {
			//outputview 에서 성공 출력문
			//inputview에서 resart 출력문
			return true;
		}

		if (userBall.getStrike() == 0 && userBall.getBall() == 0) {
			//outputview 에서 낫싱 출력문
			return false;
		}

		if (userBall.getBall() != 0 && userBall.getStrike() != 0) {
			//outputview 에서 볼, 스트라이크 출력문
			return false;
		}

		if (userBall.getBall() != 0) {
			//outputview 에서 볼 출력문
			return false;
		}

		if (userBall.getStrike() != 0) {
			//outputview 에서 스트라이크 출려문
			return false;
		}

		return false;

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
