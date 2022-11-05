package baseball;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private final static String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private Opponent opponent = new Opponent();
	private User user = new User();
	public void start() {
		System.out.println(START_MESSAGE);
		opponent.generateAnswerNumber();
		user.inputNumber();
	}
}
