package baseball;

import java.util.Arrays;

public enum NextStepInput {
	RESTART("1")
	,END("2");

	private final String inputCode;

	NextStepInput(String inputCode) {
		this.inputCode = inputCode;
	}

	public static NextStepInput fromInputCode(String input) {
		return Arrays.stream(values())
				.filter(x->(x.inputCode).equals(input))
				.findFirst()
				.orElseThrow(() -> new IllegalArgumentException(Message.INVALID_ARGUMENT_EXCEPTION_MESSAGE));
	}
}
