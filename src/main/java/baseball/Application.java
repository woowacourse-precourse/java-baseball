package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		playGame();
	}

	private static void playGame() {

		String message = "숫자 야구 게임을 시작합니다.";
		System.out.println(message);

		List<Integer> batterSelectList = batterNumberList();

		while(true) {

			message = roundResult(batterSelectList, pitcherNumberList());
			System.out.println(message);

			if(message.equals("3스트라이크")) {
				message = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
				System.out.println(message);
				break;
			}

		}

		selectGameStart();
	}

	private static void selectGameStart()  {

		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
		String select = Console.readLine();

		if(select.equals("1")) {
			playGame();
			return;
		}

		if(select.equals("2")) {
			return;
		}
	}

	private static List<Integer> batterNumberList() {

		List<Integer> computerSelectList = new ArrayList<>();

		while(computerSelectList.size() < 3) {

			int computerSelect = Randoms.pickNumberInRange(1, 9);

			if(!computerSelectList.contains(computerSelect)) {
				computerSelectList.add(computerSelect);
			}

		}

		return computerSelectList;
	}

	private static List<Integer> pitcherNumberList() {

		List<Integer> userSelectList = new ArrayList<>();

		System.out.print("숫자를 입력해주세요 : ");
		int userSelect = Integer.parseInt(Console.readLine());

		userSelectList.add(userSelect / 100);
		userSelectList.add(userSelect % 100 / 10);
		userSelectList.add(userSelect % 10);

		for(int i = 0; i < userSelectList.size(); i++) {
			for(int j = i + 1; j < userSelectList.size(); j++) {
				checkValidate(userSelectList.get(i), userSelectList.get(j));
			}
		}

		return userSelectList;
	}

	private static void checkValidate(int firstNumber, int secondNumber) {
		if(firstNumber == secondNumber) {
			try {
				throw new IllegalArgumentException();
			} catch(IllegalArgumentException e) {
				e.printStackTrace();
				return;
			}
		}
	}

	private static String roundResult(List<Integer> batterNumberList ,List<Integer> pitcherNumberList) {

		String result = "";

		int countStrike = 0, countBall = 0;

		for(int i = 0; i < 3; i++) {

			if(batterNumberList.get(i) != pitcherNumberList.get(i)) {

				if(batterNumberList.contains(pitcherNumberList.get(i))) {
					countBall++;
				}

			}

			if(batterNumberList.get(i) == pitcherNumberList.get(i)) {
				countStrike++;
			}

		}

		if(countBall > 0) {

			String space = "";

			if(countStrike > 0) {
				space = " ";
			}

			result += countBall + "볼" + space;
		}

		if(countStrike > 0) {
			result += (countStrike + "스트라이크");
		}

		if(countBall == 0 && countStrike == 0) {
			result = "낫싱";
		}

		return result;
	}

}