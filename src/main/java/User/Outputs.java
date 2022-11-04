package User;

public enum Outputs {
	GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
	ASK_INPUT_MESSAGE("숫자를 입력해주세요 : "),
	NUMBER_OF_BALL_MESSAGE("%d볼"),
	NUMBER_OF_STRIKE_MESSAGE("%d스트라이크"),
	NOTHING_MESSAGE("낫싱"),
	GAME_END_MESSAGE("%d개의 숫자를 모두 맞히셨습니다! 게임 종료"),
	RESTART_OR_NOT_MESSAGE("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.");
	private final String message;

	Outputs(String message) {
		this.message = message;
	}

	public String get() {
		return this.message;
	}
}