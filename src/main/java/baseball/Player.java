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
	private static final String END_OR_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	private static final String ERROR = "[ERROR]";
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
		System.out.print(USER_INPUT_GUIDE_MESSAGE);
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
		System.out.println(END_OR_RESTART_MESSAGE);
		String reOrEnd = Console.readLine();

		return reOrEnd;
	}
}
