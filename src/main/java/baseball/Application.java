package baseball;

import java.util.ArrayList;
import java.util.List;

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
}
