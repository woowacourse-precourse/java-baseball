package baseball;

public class OutputView {

	private final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

	public void display(final CompareResult result) {
		System.out.println(String.join(" ", result.getResults()));

		if (result.isAllStrikes()) {
			System.out.println(GAME_END_MESSAGE);
		}
	}
}
