package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
	List<Integer> numbers;

	public Player(String number) {
		this.numbers = convertStringToList(number);
	}

	private List<Integer> convertStringToList(String playerNumber) {
		String[] playerNumberArray = playerNumber.split("");
		return Arrays.stream(playerNumberArray)
			.map(number -> Integer.parseInt(number))
			.collect(Collectors.toList());
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
}
