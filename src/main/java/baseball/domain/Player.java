package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import baseball.input.InputLength;

public class Player {
	private List<Integer> playerNumberList;

	public Player() {
		playerNumberList = new ArrayList<>(InputLength.NUMBER_INPUT_LENGTH.getLength());
	}

	public void addPlayerNumberInList(String playerInput) {
		initPlayerNumber();
		separateNumbersByUnit(playerInput);
	}

	private void initPlayerNumber() {
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
