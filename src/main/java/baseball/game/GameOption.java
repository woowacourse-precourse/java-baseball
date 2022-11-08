package baseball.game;

import java.util.Arrays;

public enum GameOption {
	NOT_DECIDED(-1),
	RESTART(1),
	TERMINATE(2);

	private final int value;

	GameOption(int value) {
		this.value = value;
	}

	public static GameOption of(final int value) {
		return Arrays.stream(values())
			.filter(gameOption -> gameOption.value == value)
			.findFirst()
			.orElse(NOT_DECIDED);
	}

	public boolean isRestart() {
		return this == RESTART;
	}
}
