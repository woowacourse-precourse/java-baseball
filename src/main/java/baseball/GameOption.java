package baseball;

import java.util.Arrays;

public enum GameOption {
	RESTART(1),
	TERMINATE(2);

	private final int value;

	GameOption(int value) {
		this.value = value;
	}

	public static boolean matchOption(int value) {
		return Arrays.stream(values())
			.anyMatch(option -> option.value == value);
	}

	public static GameOption of(final int value) {
		return Arrays.stream(values())
			.filter(gameOption -> gameOption.value == value)
			.findFirst()
			.orElse(null);
	}

	public boolean isRestart() {
		return this == RESTART;
	}
}
