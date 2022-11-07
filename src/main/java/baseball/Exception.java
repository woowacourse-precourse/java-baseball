package baseball;

import java.util.List;

public class Exception {

	public void sizeCheck(String input) throws IllegalArgumentException {
		if (input.length() != 3) {
			throw new IllegalArgumentException("입력한 수는 세자리여야 합니다.");
		}
	}

	public void inputRange(List<Integer> playerNum) throws IllegalArgumentException {
		if (playerNum.contains(0)) {
			throw new IllegalArgumentException("1에서 9사이의 숫자가 아닙니다.");
		}
	}

	public void reduplication(List<Integer> playerNum, String input, int i) throws IllegalArgumentException {
		if (playerNum.contains((input.charAt(i)) - '0')) {
			throw new IllegalArgumentException("중복 되었습니다.");
		}
	}

	public boolean retry(String answer) throws IllegalArgumentException {
		if (Integer.valueOf(answer) != 1 && Integer.valueOf(answer) != 2) {
			throw new IllegalArgumentException("1 또는 2 이외의 숫자를 입력하였습니다.");
		}
		if(Integer.valueOf(answer) == 1){
			return true;
		}
		return false;
	}
}
