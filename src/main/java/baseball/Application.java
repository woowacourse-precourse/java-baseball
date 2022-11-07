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

		int strike = sumStrike(computerNumbers, playerNumbers);
		int ball = sumBall(computerNumbers, playerNumbers) - strike;
		
		System.out.println(computerNumbers);
		System.out.println(playerNumbers);
	}
	
	public static int sumBall(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		
		int count = 0;
		for (int index = 0; index < LENGTH; index++) {
			
			int player = playerNumbers.get(index);
			boolean isBall = computerNumbers.contains(player);
			if (isBall) {
				count++;
			}
		}
		return count;
	}
	
	public static int sumStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
		
		int count = 0;
		for (int index = 0; index < LENGTH; index++) {
			
			int computer = computerNumbers.get(index);
			int player = playerNumbers.get(index);
			
			boolean isStrike = computer == player;
			if (isStrike) {
				count++;
			}
		}
		return count;
	}

	public static void endGame() {

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

		int result = Integer.parseInt(Console.readLine());
		if (result == 1) {

			startGame();
		}
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

			Integer number = handleNumberException(playerNumbers);
			playerNumbers.add(number);
		}
		return playerNumbers;
	}

	public static Integer handleNumberException(List<Integer> playerNumbers) {

		String input = Console.readLine();
		
		boolean isNumeric = isNumeric(input);
		if (!isNumeric) {
			throw new IllegalArgumentException();
		}

		Integer number = Integer.parseInt(input);

		boolean isZero = number == 0;
		boolean isOverlap = playerNumbers.contains(number);
		if (isZero || isOverlap) {
			throw new IllegalArgumentException();
		}

		return number;
	}

	public static boolean isNumeric(String input) {

		try {
			Double.parseDouble(input);
			return true;
		}
		
		catch (NumberFormatException e) {
			return false;
		}
	}

	public static void startGame() {

		System.out.println("숫자 야구 게임을 시작합니다.");
	}
}
