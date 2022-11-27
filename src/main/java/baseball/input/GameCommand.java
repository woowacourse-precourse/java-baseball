package baseball.input;

public enum GameCommand {
	RE_START(1), END(2);

	private int command;

	GameCommand(int command){
		this.command = command;
	}

	public int getCommand() {
		return command;
	}
}
