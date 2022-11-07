package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class User {

	private final List<Integer> userInputNumberList = new ArrayList<>();

	public void addAllUserInputNumberList(List<Integer> list) {
		userInputNumberList.addAll(list);
	}

	public List<Integer> getUserInputNumberList() {
		return userInputNumberList;
	}

	public void clearUserInputNumberList() {
		userInputNumberList.clear();
	}

	public String readUserInputString() {
		return Console.readLine();
	}
}
