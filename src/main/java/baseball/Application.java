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
		playGame(computerNumbers);

	}

	public static void playGame(List<Integer> computerNumbers) {

		List<Integer> playerNumbers;
		playerNumbers = getPlayerNumbers();

		int strike = sumStrike(computerNumbers, playerNumbers);
		if (strike == LENGTH) {

			System.out.println("3스트라이크");
			endGame();
			return;
		}

		int ball = sumBall(computerNumbers, playerNumbers) - strike;

		boolean isNothing = strike == 0 && ball == 0;
		if (isNothing) {
			System.out.println("낫싱");
		}

		else {
			System.out.println(ball + "볼 " + strike + "스트라이크");
		}

		System.out.println(computerNumbers);
		System.out.println(playerNumbers);
		playGame(computerNumbers);
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

		String result = Console.readLine();
		if (result == "1") {

			List<Integer> computerNumbers = getComputerNumbers();
			playGame(computerNumbers);
		}

		else if (result == "2") {
			return;
		}

		else {
			System.out.println("게임 종료");
			throw new IllegalArgumentException();
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

		System.out.print("숫자를 입력해주세요 : ");
		String input = Console.readLine();

		boolean isNumeric = isNumeric(input);
		boolean isSameLength = input.length() == LENGTH;
		if (!isNumeric || !isSameLength) {

			System.out.println("게임 종료");
			throw new IllegalArgumentException();
		}

		List<Integer> playerNumbers = new ArrayList<Integer>(LENGTH);

		for (int character = 0; character < input.length(); character++) {

			int number = Character.getNumericValue(input.charAt(character));

			boolean isZero = number == 0;
			boolean isOverlap = playerNumbers.contains(number);
			if (isZero || isOverlap) {

				System.out.println("게임 종료");
				throw new IllegalArgumentException();
			}

			playerNumbers.add(number);
		}

		return playerNumbers;
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
