package baseball.rule;

import baseball.player.Computer;
import baseball.player.Player;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballGameRule {

	private Player player;
	private Computer computer;
	private String playerNumber;
	private String computerNumber;
	private List<Integer> scoreList;
	private static final int STRIKE_INDEX = 0;
	private static final int BALL_INDEX = 1;
	private static final String NUMBER_START = "1";
	private static final String NUMBER_END = "9";
	private static final int NUMBER_LENGTH = 3;

	public BaseballGameRule(Player player, Computer computer) {
		this.player = player;
		this.computer = computer;
		computerNumber = computer.getNumber();
		scoreList = new ArrayList<>(Arrays.asList(0, 0));
	}

	public void isPlayerNumberValidate() {
		playerNumber = player.getNumber();
		if (!isLength3() || !isNumber() || !isDifferentNumbersEach()) {
			throw new IllegalArgumentException("올바른 값을 입력하세요(서로 다른 숫자 3개");
		}
	}

	private boolean isLength3() {
		return playerNumber.length() == NUMBER_LENGTH;
	}

	private boolean isNumber() {
		return playerNumber.matches("^[" + NUMBER_START + "-" + NUMBER_END + "]*$");
	}

	private boolean isDifferentNumbersEach() {
		return playerNumber.equals(removeDistinctNumber());
	}

	private String removeDistinctNumber() {
		return Arrays.stream(playerNumber.split("")).distinct()
				.collect(Collectors.joining());
	}

	public String getScore() {
		scoreList = new ArrayList<>(Arrays.asList(0, 0));
		countStrike();
		countBall();
		return convertListToString(scoreList);
	}

	private String convertListToString(List<Integer> scoreList) {
		return scoreList.stream().map(String::valueOf).collect(Collectors.joining());
	}

	private void countStrike() {
		if (playerNumber.equals(computerNumber)) {
			scoreList.set(STRIKE_INDEX, 3);
		}
		int count = 0;
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if (isCharEquals(i)) {
				count++;
			}
		}
		scoreList.set(STRIKE_INDEX, count);
	}

	private void countBall() {
		int count = 0;
		for (int i = 0; i < NUMBER_LENGTH; i++) {
			if (!isCharEquals(i) && isPlayerNumberContains(i)) {
				count++;
			}
		}
		scoreList.set(BALL_INDEX, count);

	}
	private boolean isCharEquals(int index){
		return playerNumber.charAt(index) == computerNumber.charAt(index);
	}
	private boolean isPlayerNumberContains(int index){
		return computerNumber.indexOf(playerNumber.charAt(index)) != -1;
	}


}
