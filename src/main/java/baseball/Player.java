package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Player {
	private static final int UNIT_HUNDRED = 100;
	private static final int UNIT_TEN = 10;
	private static final int INIT_LIST_CAPACITY = 3;
	private static List<Integer> userNumberList;

	public Player() {
		userNumberList = new ArrayList<>(INIT_LIST_CAPACITY);
	}

	protected void makeUserNumber(String userInput) {
		initUserNumber();
		makeUserInput(userInput);
	}

	private void makeUserInput(String userInput) {
		int userInputToInt = Integer.parseInt(userInput);

		addUserNumber(userInputToInt);
	}

	protected String inputNumber() {
		View.showUerInputGuideMessage();
		String str = Console.readLine();

		return str;
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

	protected String inputEndOrRe() {
		View.showEndOrRestartGuideMessage();
		String reOrEnd = Console.readLine();

		return reOrEnd;
	}
}
