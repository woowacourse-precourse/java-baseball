package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
	public static void main(String[] args) {
		// TODO: 프로그램 구현
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
}
