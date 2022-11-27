package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
	private static final int INIT_LIST_CAPACITY = 3;
	private List<Integer> playerNumberList;

	public Player() {
		playerNumberList = new ArrayList<>(INIT_LIST_CAPACITY);
	}

	public void addPlayerNumberInList(String playerInput) {
		initUserNumber();
		separateNumbersByUnit(playerInput);
	}

	private void initUserNumber() {
		playerNumberList.clear();
	}

	public void separateNumbersByUnit(String playerInput) {
		int[] numbers = Stream.of(String.valueOf(playerInput).split("")).mapToInt(Integer::parseInt).toArray();

		playerNumberList = Arrays.stream(numbers)
			.boxed()
			.collect(Collectors.toList());
	}

	public List<Integer> getPlayerNumberList() {
		return Collections.unmodifiableList(playerNumberList);
	}
}
