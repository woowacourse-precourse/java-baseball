package baseball.program;

public class Program {
	private static ProgramStatus programStatus = ProgramStatus.START;

	public static boolean isProgramEnd() {
		return programStatus == ProgramStatus.END;
	}
}
