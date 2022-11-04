package baseball;

import java.util.List;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class Application {

	static final int LENGTH = 3;

	public static void main(String[] args) {

		startGame();

		List<Integer> computerNumbers = getComputerNumbers();
		List<Integer> playerNumbers = getPlayerNumbers();
		
		System.out.println(computerNumbers);
		System.out.println(playerNumbers);
	}

	public static List<Integer> getComputerNumbers() {

		List<Integer> computer = new ArrayList<>();
		while (computer.size() < LENGTH) {

			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}

	public static List<Integer> getPlayerNumbers() {

		List<Integer> playerNumbers = new ArrayList<Integer>(LENGTH);

		for (int count = 0; count < LENGTH; count++) {

			Integer number = Integer.parseInt(Console.readLine());
			playerNumbers.add(number);
		}
		return playerNumbers;
	}

	public static void startGame() {

		System.out.println("숫자 야구 게임을 시작합니다.");
	}
}
