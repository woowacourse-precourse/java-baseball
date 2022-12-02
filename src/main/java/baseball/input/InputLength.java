package baseball.input;

public enum InputLength {
	GAME_COMMAND_INPUT_LENGTH (1),
	END_INPUT_LENGTH (2),
	RESTART_INPUT_LENGTH (1),
	NUMBER_INPUT_LENGTH (3);

	private int length;

	InputLength(int length){
		this.length = length;
	}

	public int getLength() {
		return length;
	}
}
