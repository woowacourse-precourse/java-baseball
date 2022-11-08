package baseball.view;

import baseball.domain.CompareResult;

public class OutputView {

	private final static String GAME_END_MESSAGE
		= "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public static void display(final CompareResult result) {
		System.out.println(String.join(" ", result.getResults()));

		if (result.isGameEnd()) {
			System.out.println(GAME_END_MESSAGE);
		}
	}
}
