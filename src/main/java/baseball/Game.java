package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private final static String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
	private Opponent opponent = new Opponent();
	private User user = new User();
	public void start() {
		System.out.println(START_MESSAGE);
		opponent.generateAnswerNumber();
		user.inputNumber();

	}

	public boolean restart() {
		System.out.println(RESTART_MESSAGE);
		String restart = readLine();

		if (restart.equals("1")) {
			return true;
		}
		return false;
	}
}
