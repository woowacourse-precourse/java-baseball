package baseball.domain;

import java.util.ArrayList;
import java.util.List;

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

}
