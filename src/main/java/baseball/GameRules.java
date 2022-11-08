package baseball;

public enum GameRules {
	DIGIT_NUMBER(3),MINIMUM_NUMBER(1), MAXIMUM_NUMBER(9), GAME_RESTART(1),GAME_END(2);
	private final Integer code;
	GameRules(Integer code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

}
