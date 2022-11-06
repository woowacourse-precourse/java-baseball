package baseball.controller;

import java.util.ArrayList;

import baseball.domain.Balls;
import baseball.domain.BaseballGameResult;

public class BaseballGameController {

	public static Balls pickComputerBalls() {
		return new Balls(new ArrayList<>());
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
