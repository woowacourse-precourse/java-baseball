package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private static final int UNIT_HUNDRED = 100;
	private static final int UNIT_TEN = 10;
	private static final int INIT_LIST_CAPACITY = 3;
	private static final int INIT_INDEX = 0;
	private static final String USER_INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String ERROR = "[ERROR]";
	private static List<Integer> userNumberList;

	public Player() {
		userNumberList = new ArrayList<>(INIT_LIST_CAPACITY);
	}

	protected void makeUserNumber() {
		initUserNumber();
		checkUserInput();
	}

	private void checkUserInput() {
		int userInput = Integer.parseInt(inputNumber());

		addUserNumber(userInput);

		for (int targetIndex = INIT_INDEX; targetIndex < userNumberList.size() - 1; targetIndex++) {
			int target = userNumberList.get(targetIndex);

			checkSameNumberExist(targetIndex, target);
		}
	}

	private String inputNumber() {
		System.out.print(USER_INPUT_GUIDE_MESSAGE);
		String str = Console.readLine();

		return str;
	}

	private void checkSameNumberExist(int targetIndex, int target) {
		for (int compareIndex = targetIndex + 1; compareIndex < userNumberList.size(); compareIndex++) {
			int compareNumber = userNumberList.get(compareIndex);

			if (target == compareNumber) {
				throw new IllegalArgumentException(ERROR + "중복되는 숫자는 입력할 수 없습니다.");
			}
		}
	}

	private void addUserNumber(int userNumber) {
		userNumberList.add(userNumber / UNIT_HUNDRED);
		userNumberList.add((userNumber % UNIT_HUNDRED) / UNIT_TEN);
		userNumberList.add((userNumber % UNIT_HUNDRED) % UNIT_TEN);
	}

	private void initUserNumber() {
		userNumberList.clear();
	}

	protected List<Integer> getUserNumberList() {
		return userNumberList;
	}
}
