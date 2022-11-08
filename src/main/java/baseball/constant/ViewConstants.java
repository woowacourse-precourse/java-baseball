package baseball.constant;

public enum ViewConstants {
	GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
	ASKING_INPUT_MESSAGE("숫자를 입력해주세요 : "),
	BALLS_COUNT_MESSAGE("%d볼"),
	STRIKES_COUNT_MESSAGE("%d스트라이크"),
	NOTHING_MESSAGE("낫싱"),
	FINISHING_GAME_MESSAGE("%d개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	RESTART_OR_NOT_MESSAGE("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.");
	private final String message;

	ViewConstants(String message) {
		this.message = message;
	}

	public String get() {
		return this.message;
	}
}