package baseball.view;

import baseball.model.BaseballModel;

import java.util.ArrayList;
import java.util.List;

public class OutputView {
	private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
	private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
	private static final String BALL_MESSAGE = "볼";
	private static final String STRIKE_MESSAGE = "스트라이크";
	private static final String NO_MATCH_MESSAGE = "낫싱";

	public static void printGameStartMessage(){
		System.out.println(START_MESSAGE);
	}

	public static void printTryResult(BaseballModel model){
		String result = getResult(model.ball, model.strike);
		System.out.println(result);
	}

	public static String getResult(int ball, int strike) {
		List<String> result = new ArrayList<>();
		if (ball > 0){
			result.add(ball + BALL_MESSAGE);
		}
		if (strike > 0){
			result.add(strike + STRIKE_MESSAGE);
		}
		if (result.size() == 0) {
			result.add(NO_MATCH_MESSAGE);
		}
		return String.join(" ", result);
	}

	public static void printGameWinMessage(){
		System.out.println(WIN_MESSAGE);
	}
}
