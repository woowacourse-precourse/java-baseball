package baseball;

import java.util.Arrays;

public enum NextStepInput {
	RESTART("1")
	,END("2");

	private final String inputCode;

	NextStepInput(String inputCode) {
		this.inputCode = inputCode;
	}

	public static NextStepInput fromInputCode(String inputCode) {
		return Arrays.stream(values())
				.filter(x->x.inputCode.equals(inputCode))
				.findFirst()
				.orElseThrow(IllegalArgumentException::new);
	}
}
