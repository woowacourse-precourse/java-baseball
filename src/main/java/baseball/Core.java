package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Core {

	List<Integer> computer = new ArrayList<>();
	User user = new User();
	boolean start;

	public void init() {
		user.init();
		computer.clear();
		generateRandomNum();
		start = true;
	}

	public void generateRandomNum() {
		while (computer.size() < 3) {
			int randomNum = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNum)) {
				computer.add(randomNum);
			}
		}
	}

	public void checkStrikeBall() {
		for (int index = 0; index < user.num.length(); index++) {
			int userNum = user.num.charAt(index) - '0';
			//같은 자리 같은 숫자
			if (isStrike(userNum, index)) {
				user.strike++;
				continue;
			}
			//다른 자리 같은 숫자
			if (isBall(userNum)) {
				user.ball++;
			}
		}
	}

	public boolean isStrike(int userNum, int index) {
		if (computer.get(index) == userNum) {
			return true;
		}
		return false;
	}

	public boolean isBall(int userNum) {
		for (Integer computerNum : computer) {
			if (computerNum == userNum) {
				return true;
			}
		}
		return false;
	}

	public void checkRestart() {
		int userInput = Integer.parseInt(Console.readLine());
		checkException(userInput);
		if (userInput == 1) {
			init();
			return;
		}
		start = false;
	}

	private void checkException(int userInput) {
		if (userInput != 1 && userInput != 2) {
			throw new IllegalArgumentException();
		}
	}
}