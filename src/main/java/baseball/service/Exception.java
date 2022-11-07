package baseball.service;

public class Exception {
	public void checkSize(String input) throws IllegalArgumentException {
		if (input.length() != 3) {
			throw new IllegalArgumentException("숫자를 3개 입력해 주세요.");
		}
	}

}
