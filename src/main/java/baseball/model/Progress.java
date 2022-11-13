package baseball.model;

public enum Progress {
	RESTART(1), EXIT(2);

	private final int code;

	Progress(int code) {
		this.code = code;
	}

	public static Progress askRestartOrExitGameFromUser(int code) {
		if (code == RESTART.code) {
			return RESTART;
		} else if (code == EXIT.code) {
			return EXIT;
		}

		throw new IllegalArgumentException("[Error] 잘못된 입력입니다.");
	}

	public boolean isRestart() {
		return this.code == RESTART.code;
	}
}
