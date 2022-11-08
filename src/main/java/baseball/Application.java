package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	 //1,3,5,5,8,9

	public static void main(String[] args) {
		gameStart();
	}

	public static List<Integer> getRandomNum() {
		List<Integer> computer = new ArrayList<>(3);
		while (computer.size() < 3) {
			Integer randomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(randomNumber)) {
				computer.add(randomNumber);
			}
		}
		return computer;
	}

	public static void gameStart() {
		System.out.println("숫자 야구 게임을 시작합니다.");
		for (int i = 0; i < 3; i++) //게임을 3번 진행
		{
			List<Integer> computer = getRandomNum();
			nextGameOrNot(computer);

			String number="";
			number = Console.readLine();
			if(!GameOverOrRestart(number))
			{

				break;
			}

		}
	}

	public static void nextGameOrNot(List<Integer> computerNum) {
		String number = "";
		while (true) {
			System.out.println("숫자를 입력해주세요 : ");
			number = Console.readLine();
			numberCheck(number);
			if (returnBallStrike(number,computerNum)){
				break;
			}

		}
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	public static boolean GameOverOrRestart(String number) {
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		if (!number.equals("1") && !number.equals("2")) {
			makeException();
		} else if (number.equals("2")) {
			System.out.println("게임 종료");
			return false;
		}
		return true;
	}

	public static void numberCheck(String number) {
		numberLength3Check(number);
		number0To9(number);
		numberSameIn(number);
	}

	public static void numberLength3Check(String number) {
		if (number.length() != 3) {
			makeException();
		}
	}

	public static void number0To9(String number) {
		for (int i = 0; i < 3; i++) {
			if (number.charAt(i) < '0' && number.charAt(i) > '9') {
				makeException();
			}
		}
	}

	public static void numberSameIn(String number) {
		for (int i = 0; i < 3; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (number.charAt(i) == number.charAt(j)) {
					makeException();
				}
			}
		}
	}

	public static void makeException() {
		try {
			throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			throw 	new IllegalArgumentException(e);
		}
	}

	public static boolean returnBallStrike(String number,List<Integer> computer) // "246" 135 비교
	{
		int ball = 0;
		int strike = 0;
		String computerNum  = makeStringNum(computer);
		for (int i = 0; i < 3; i++) {
			if (computerNum.indexOf(number.charAt(i)) == i) {
				strike++;
				continue;
			}
			if (computerNum.indexOf(number.charAt(i)) != -1)
				ball++;
		}
		if (strike == 3) {
			System.out.println(strike + "스트라이크");
			return true;
		} else if (strike > 0 || ball > 0) {
			System.out.println(ball + "볼 " + strike + "스트라이크");
			return false;
		}
		System.out.println("낫싱");
		return false;
	}
	public static String makeStringNum(List<Integer> computer)
	{
		String result="";
		for(int i=0; i<3; i++)
		{
			result += String.valueOf(computer.get(i));
		}

		return result;
	}

}


/*
	package baseball;

	import java.util.List;
	import java.util.ArrayList;
	import camp.nextstep.edu.missionutils.*;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
		String input;
		boolean retry;

		System.out.println("숫자 야구 게임을 시작합니다.");

		do {
			gameLoop();

			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
			input = Console.readLine();
			if (input.equals("1"))
				retry = true;
			else if (input.equals("2"))
				retry = false;
			else
				throw new IllegalArgumentException();
		} while (retry);
	}

	private static void gameLoop() {
		List<Integer> computerNumber = generateThreeRandomNumber();
		List<Integer> userNumber;

		do {
			String input;

			System.out.print("숫자를 입력해주세요 : ");
			input = Console.readLine();
			userNumber = parseInput(input);
		} while (!judgement(computerNumber, userNumber));

		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
	}

	private static List<Integer> generateThreeRandomNumber() {
		List<Integer> computerNumber = new ArrayList<>(3);

		for (int i = 0; i < 3; i++) {
			Integer num = Randoms.pickNumberInRange(1, 9);

			if (computerNumber.contains(num)) {
				i--;
				continue;
			}
			computerNumber.add(num);
		}

		return computerNumber;
	}

	private static List<Integer> parseInput(String input) {
		List<Integer> inputNumber = new ArrayList<>(3);

		if (input.length() != 3)
			throw new IllegalArgumentException();

		for (int i = 0;i < 3;i++) {
			char c = input.charAt(i);

			if (c < '1' || c > '9')
				throw new IllegalArgumentException();
			if (inputNumber.contains(c - '0'))
				throw new IllegalArgumentException();

			inputNumber.add(c - '0');
		}

		return inputNumber;
	}

	private static boolean judgement(List<Integer> computerNumber, List<Integer> userNumber) {
		int ball = 0, strike = 0;

		for (int i = 0;i < 3;i++) {
			if (userNumber.get(i) == computerNumber.get(i))
				strike++;
			else if (computerNumber.contains(userNumber.get(i)))
				ball++;
		}

		if (ball > 0 || strike > 0) {
			if (ball > 0)
				System.out.print(ball + "볼");
			if (strike > 0 && ball > 0)
				System.out.print(" ");
			if (strike > 0) {
				System.out.print(strike + "스트라이크");
			}
			System.out.println("");
		}
		else {
			System.out.println("낫싱");
		}

		if (strike == 3)
			return true;
		return false;
	}
}*/


