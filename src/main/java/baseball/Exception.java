package baseball;

import java.util.List;

public class Exception {

	public void sizeCheck(String input) throws IllegalArgumentException {
		if (input.length() != 3) {
			throw new IllegalArgumentException("입력한 수는 세자리여야 합니다.");
		}
	}
}
