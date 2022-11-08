package baseball;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class Batter {
	private final PlayingNumber playingNumber;

	public Batter() {
		String userInput = Console.readLine();
		this.playingNumber = new PlayingNumber(userInput);
	}

	public List<Integer> getPlayingNumbers() {
		return playingNumber.getPlayingNumbers();
	}

}
