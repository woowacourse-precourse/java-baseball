package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Input {
	public List<Integer> playerNumber() {
		Exception exception = new Exception();
		System.out.print("숫자를 입력해주세요 : ");
		List<Integer> playerNum = new ArrayList<>();
		String input = Console.readLine();
		exception.sizeCheck(input);

		for (int i = 0; i < input.length(); i++) {
			exception.reduplication(playerNum, input, i);
			playerNum.add(conversion(input, i));
		}

		exception.inputRange(playerNum);
		return playerNum;
	}

	public int conversion(String input, int i) {
		return (input.charAt(i)) - '0';
	}
}