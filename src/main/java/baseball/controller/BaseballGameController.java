package baseball.controller;

import static baseball.constant.Constants.*;
import static baseball.validator.BallValidator.*;
import static baseball.validator.GameInputValidator.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import baseball.domain.Balls;
import baseball.domain.BaseballGameResult;
import baseball.view.UserInputView;
import camp.nextstep.edu.missionutils.Randoms;

public class BaseballGameController {

	public static Balls pickComputerBalls() {
		Set<Integer> pickedBalls = new HashSet<>();
		while (pickedBalls.size() < NUMBER_OF_BALLS_FOR_BASEBALL_GAME) {
			int pickedBall = Randoms.pickNumberInRange(START_NUMBER_FOR_BASEBALL_GAME, END_NUMBER_FOR_BASEBALL_GAME);
			pickedBalls.add(pickedBall);
		}
		return new Balls(new ArrayList<>(pickedBalls));
	}

	public static Balls pickUserBalls() {
		UserInputView.printPickUserBalls();
		String userInput = UserInputView.receiveInput();
		validateInputIsNumeric(userInput);

		List<Integer> ballsPickedByUser = Arrays.stream(userInput.split(""))
			.map(Integer::parseInt)
			.collect(Collectors.toList());
		validateDuplicate(ballsPickedByUser);
		validateNumberOfBalls(ballsPickedByUser);
		return new Balls(ballsPickedByUser);
	}

	public static int judgeStrike(Balls ballsPickedByComputer, Balls ballsPickedByUser) {
		int numberOfStrike = 0;
		for (int ballIndex = 0; ballIndex < NUMBER_OF_BALLS_FOR_BASEBALL_GAME; ballIndex++) {
			int result = ballsPickedByComputer.containsAndIndexOf(ballsPickedByUser.getPickedBalls().get(ballIndex));
			if (result == NOT_CONTAINS) {
				continue;
			} else if (result == ballIndex) {
				numberOfStrike++;
			}
		}
		return numberOfStrike;
	}

	public static int judgeBall(Balls ballsPickedByComputer, Balls ballsPickedByUser) {
		int numberOfBall = 0;
		for (int ballIndex = 0; ballIndex < NUMBER_OF_BALLS_FOR_BASEBALL_GAME; ballIndex++) {
			int result = ballsPickedByComputer.containsAndIndexOf(ballsPickedByUser.getPickedBalls().get(ballIndex));
			if (result == NOT_CONTAINS) {
				continue;
			} else if (result != ballIndex) {
				numberOfBall++;
			}
		}
		return numberOfBall;
	}

	public static BaseballGameResult judge(Balls ballsPickedByComputer, Balls ballsPickedByUser) {
		int numberOfStrike = judgeStrike(ballsPickedByComputer, ballsPickedByUser);
		int numberOfBall = judgeBall(ballsPickedByComputer, ballsPickedByUser);
		return new BaseballGameResult(numberOfStrike, numberOfBall);
	}

	private static boolean askRestartGame() {
		UserInputView.printRestartGame();
		String input = UserInputView.receiveInput();
		validateRestartInput(input);

		int inputParseInt = Integer.parseInt(input);
		if (inputParseInt == RESTART_GAME) {
			return true;
		}
		return false;
	}

	private static boolean isGameOver(BaseballGameResult result) {
		return false;
	}
}
