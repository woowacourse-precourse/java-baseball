package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

	public static void main(String[] args) {

	}

	public static List<Integer> computer() {
		List<Integer> computer = new ArrayList<Integer>();
		while (computer.size() < 3) {
			int RandomNumber = Randoms.pickNumberInRange(1, 9);
			if (!computer.contains(RandomNumber)) {
				computer.add(RandomNumber);
			}
		}
		return computer;
	}

	public static List<Integer> user() {
		String userInput = Console.readLine();
		String[] userInputArray = userInput.split("");
		List<Integer> user = new ArrayList<Integer>();
		for (int index = 0; index < userInputArray.length; index++) {
			int digitNumber = Integer.parseInt(userInputArray[index]);
			user.add(digitNumber);
			if (!user.contains(digitNumber)) {
				throw new IllegalArgumentException();
			}
		}
		if (user.size() != 3) {
			throw new IllegalArgumentException();
		}
		return user;
	}

	public static String compareResult(List<Integer> computerList, List<Integer> userList) {
		String result = "";

		int ball = 0;
		for (int userIndex = 0; userIndex < userList.size(); userIndex++) {
			int userNumber = userList.indexOf(userIndex);
			if (computerList.contains(userNumber)) {
				ball++;
			}
		}

		int strike = 0;
		for (int index = 0; index < 3; index++) {
			int userNumber = userList.indexOf(index);
			int computerNumber = computerList.indexOf(index);
			if (userNumber == computerNumber) {
				strike++;
			}
		}

		if (ball != 0 && strike != 0) {
			System.out.println(ball + "볼" + " " + strike + "스트라이크");
			result = "ball & strike";
		}

		if (ball != 0 && strike == 0) {
			System.out.println(ball + "볼");
			result = "strike";
		}

		if (ball == 0 && strike != 0) {
			System.out.println(strike + "스트라이크");
			result = "ball";
		}

		if (ball == 0 && strike == 0) {
			System.out.println("낫싱");
			result = "nothing";
		}

		if (ball == 3 && strike == 3) {
			System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
			result = "win";
		}

		return result;
	}
}
