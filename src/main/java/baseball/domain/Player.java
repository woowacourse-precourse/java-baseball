package baseball.domain;

import java.util.List;

public class Player {

	List<Integer> playerNumbers;

	public Player(List<Integer> playerNumbers) {
		this.playerNumbers = playerNumbers;
	}

	public List<Integer> getPlayerNumbers() {
		return playerNumbers;
	}

	public void setPlayerNumbers(List<Integer> playerNumbers) {
		this.playerNumbers = playerNumbers;
	}
}
