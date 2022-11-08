package baseball.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserPlayer {
	private static UserPlayer userPlayer = null;
	private UserPlayer() {
	}

	public static UserPlayer getInstance() {
		if (userPlayer == null) {
			userPlayer = new UserPlayer();
		}
		return userPlayer;
	}

	private List<Integer> numberList;

	public void setNumberList(String userInput) {
		String[] userInputArray = userInput.split("");
		this.numberList = Arrays.stream(userInputArray)
			.map(Integer::parseInt)
			.collect(Collectors.toList());
	}

	public List<Integer> getNumberList() {
		return numberList;
	}

}
