package baseball.model.restartcode;

import java.util.Arrays;

public enum RestartStatus {
	RESTART(1),
	END(2);

	private int statusCode;

	RestartStatus(int statusCode) {
		this.statusCode = statusCode;
	}

	public static RestartStatus valueOfCode(int	statusCode) {
		return Arrays.stream(values())
			.filter(v -> v.statusCode == statusCode)
			.findAny()
			.orElse(END);
	}
}
