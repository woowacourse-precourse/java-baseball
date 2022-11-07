package baseball.program;

public enum ProgramStatus {
	START(0),
	RESTART(1),
	END(2),
	;

	private final int command;

	ProgramStatus(int command) {
		this.command = command;
	}
}
