package baseball.exception;

public class RestartNumberException {
	public static void validateRestartNumber(String inputRestartNumber, int restartNumber, int exitNumber) {
		try {
			validateRestartOrExitNumber(inputRestartNumber, restartNumber, exitNumber);
		} catch (IllegalArgumentException error) {
			System.out.println(error);
			throw new IllegalArgumentException();
		}
	}

	public static void validateRestartOrExitNumber(String inputRestartNumber, int restartNumber, int exitNumber) {
		String stringRestartNumber = Integer.toString(restartNumber);
		String stringExitNumber = Integer.toString(exitNumber);
		if (!inputRestartNumber.equals(stringRestartNumber) && !inputRestartNumber.equals(stringExitNumber)) {
			String limitRestartNumberBoundary = String.format("[ERROR] %s혹은 %s숫자만 입력이 가능합니다.",
				stringRestartNumber, stringExitNumber);
			throw new IllegalArgumentException(limitRestartNumberBoundary);
		}
	}
}
