package baseball.controller;

import static baseball.constant.Constants.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import baseball.domain.Balls;
import baseball.domain.BaseballGameResult;
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
		return new Balls(new ArrayList<>());
	}

	private static int judgeStrike(Balls ballsPickedByComputer, Balls ballsPickedByUser) {
		return -1;
	}

	private static int judgeBall(Balls ballsPickedByComputer, Balls ballsPickedByUser) {
		return -1;
	}

	public static BaseballGameResult judge(Balls ballsPickedByComputer, Balls ballsPickedByUser) {
		return new BaseballGameResult(-1, -1);
	}

	private static boolean askRestartGame() {
		return false;
	}

	private static boolean isGameOver(BaseballGameResult result) {
		return false;
	}
}
