package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		gameStart();
	}

	public static void gameStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		List<Integer> computerPickNums = computerPick();
		gamePlaying(computerPickNums);

	}

	public static List<Integer> computerPick() {
		List<Integer> computerPickNums = new ArrayList<>();
		while (computerPickNums.size() < 3) {
			int randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computerPickNums.contains(randomNumber)) {
				computerPickNums.add(randomNumber);
			}
		}
		System.out.println(computerPickNums.get(0));
		System.out.println(computerPickNums.get(1));
		System.out.println(computerPickNums.get(2));
		return computerPickNums;
	}

	public static void gamePlaying(List<Integer> computerPickNums) {
		List<Integer> playerPickNums = playerPick();
		int strike = findStrike(computerPickNums, playerPickNums);
		int ball = findball(computerPickNums, playerPickNums);
		System.out.println(ball);
		System.out.println(strike);
		scoreBoard(strike, ball);
		winLose(strike, computerPickNums);
	}

	public static List<Integer> playerPick() {
		List<Integer> answer = new ArrayList<>();
		System.out.print("숫자를 입력해주세요 :");
		int playerInput = Integer.parseInt(Console.readLine());
		if (playerInput < 0 || playerInput > 999) {
			error();
		}
		int numOne = (int) (playerInput / 100) % 10;
		int numTwo = (int) (playerInput / 10) % 10;
		int numThree = playerInput % 10;
		if (numOne == numTwo || numTwo == numOne || numThree == numOne || numOne == 0 || numTwo == 0 || numThree == 0) {
			error();
		}
		System.out.println(numOne);
		System.out.println(numTwo);
		System.out.println(numThree);
		answer.add(numOne);
		answer.add(numTwo);
		answer.add(numThree);
		return answer;
	}

	public static void error() {
		try {
			throw new Exception("IllegalArgumentException");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int findStrike(List<Integer> computerPickNums, List<Integer> playerPickNums) {
		int strike = 0;
		for (int i = 0; i < 3; i++) {
			if (computerPickNums.get(i) == playerPickNums.get(i)) {
				strike++;
			}
		}
		return strike;
	}

	public static int findball(List<Integer> computerPickNums, List<Integer> playerPickNums) {
		int ball = 0;
		if (playerPickNums.get(0) == computerPickNums.get(1) || playerPickNums.get(0) == computerPickNums.get(2)) {
			ball++;
		}
		if (playerPickNums.get(1) == computerPickNums.get(2) || playerPickNums.get(1) == computerPickNums.get(0)) {
			ball++;
		}
		if (playerPickNums.get(2) == computerPickNums.get(0) || playerPickNums.get(2) == computerPickNums.get(1)) {
			ball++;
		}
		return ball;
	}

	public static void scoreBoard(int strike, int ball) {
		if (strike == 0 && ball == 0) {
			System.out.println("낫싱");
		} else {
			System.out.println(ball + "볼" + " " + strike + "스트라이크");
		}
	}

	public static void winLose(int strike, List<Integer> computerPickNums) {
		if (strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			gameReloader();
		} else {
			gamePlaying(computerPickNums);
		}
	}

	public static void gameReloader() {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int coin = Integer.parseInt(Console.readLine());
		if (coin == 1) {
			gameStart();
		} else if (coin == 2) {
		} else {
			error();
		}
	}
}
