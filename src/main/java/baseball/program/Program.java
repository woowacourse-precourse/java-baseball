package baseball.program;

public class Program {
	private static ProgramStatus programStatus = ProgramStatus.START;

	public static void init() {
		programStatus = ProgramStatus.START;
	}
	public static boolean isProgramEnd() {
		return programStatus == ProgramStatus.END;
	}

	public static void changeStatus(ProgramStatus programStatus) {
		Program.programStatus = programStatus;
	}

	public static boolean isProgramContinue() {
		return programStatus == ProgramStatus.RESTART;
	}
}
