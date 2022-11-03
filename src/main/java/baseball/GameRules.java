package baseball;

public enum GameRules {
	DIGIT_NUMBER(3),MINIMUM_NUMBER(1), MAXIMUM_NUMBER(9), GAME_RESTART(1),GAME_END(2);
	private final int code;
	GameRules(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	/*public abstract int getValue();*/
}
