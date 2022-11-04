package baseball.domain;

import java.util.List;

public class Player {

	List<Integer> playerNumbers;
	boolean restart;

	public Player(List<Integer> playerNumbers, boolean restart) {
		this.playerNumbers = playerNumbers;
		this.restart = restart;
	}

	public List<Integer> getPlayerNumbers() {
		return playerNumbers;
	}

	public void setPlayerNumbers(List<Integer> playerNumbers) {
		this.playerNumbers = playerNumbers;
	}

	public boolean isRestart() {
		return restart;
	}
}
