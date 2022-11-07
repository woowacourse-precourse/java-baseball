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
}
