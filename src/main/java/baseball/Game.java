package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final static String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
	private final static String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private Opponent opponent = new Opponent();
	private User user = new User();
	private Compute compute = new Compute();
	public void start() {
		opponent.generateAnswerNumber();
		do {
			user.inputNumber();
		} while (compute.computeResult(user, opponent));

		System.out.println(GAME_END_MESSAGE);
		if (restart()) {
			start();
		}
	}

	public boolean restart() {
		System.out.println(RESTART_MESSAGE);
		String restart = Valid.validRestartNumber(readLine());

		if (restart.equals("1")) {
			return true;
		}
		return false;
	}
}
