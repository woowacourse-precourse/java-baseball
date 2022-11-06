package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private static final int UNIT_HUNDRED = 100;
	private static final int UNIT_TEN = 10;
	private static final int INIT_LIST_CAPACITY = 3;
	private List<Integer> userNumberList;

	public Player() {
		userNumberList = new ArrayList<>(INIT_LIST_CAPACITY);
	}

	protected void addUserNumberInList(String userInput) {
		initUserNumber();
		separateNumbersByUnit(Integer.parseInt(userInput));
	}

	private void initUserNumber() {
		userNumberList.clear();
	}

	public void separateNumbersByUnit(int userNumber) {
		userNumberList.add(userNumber / UNIT_HUNDRED);
		userNumberList.add((userNumber % UNIT_HUNDRED) / UNIT_TEN);
		userNumberList.add((userNumber % UNIT_HUNDRED) % UNIT_TEN);
	}

	public List<Integer> getUserNumberList() {
		return userNumberList;
	}
}
