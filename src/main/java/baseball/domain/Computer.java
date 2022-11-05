package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.restrict.RestrictIntegerConstants;

public class Computer implements RestrictIntegerConstants {

	private final List<Integer> randomNumberList = new ArrayList<>();

	public void clearRandomNumberList() {
		randomNumberList.clear();
	}

	public List<Integer> getRandomNumberList() {
		return randomNumberList;
	}
}
