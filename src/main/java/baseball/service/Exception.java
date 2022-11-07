package baseball.service;

public class Exception {
	public void checkSize(String input) throws IllegalArgumentException {
		if (input.length() != 3) {
			throw new IllegalArgumentException("숫자를 3개 입력해 주세요.");
		}
	}

	public void checkNumberSize(char input) throws IllegalArgumentException {
		if (input < '1' || input > '9') {
			throw new IllegalArgumentException("숫자의 범위가 맞지 않습니다.");
		}
	}

	public void checkOverlap(int[] number, char input) throws IllegalArgumentException {
		for (int i = 0; i < number.length; i++) {
			if (number[i] == input - '0') {
				throw new IllegalArgumentException("숫자를 중복해서 입력 하였습니다.");
			}
		}
	}

}
