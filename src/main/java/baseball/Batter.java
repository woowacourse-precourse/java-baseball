package baseball;

import static camp.nextstep.edu.missionutils.Console.*;

import java.util.List;

public class Batter {
	private final PlayingNumber playingNumber;

	public Batter() {
		Broadcast.printInputMessage();
		this.playingNumber = new PlayingNumber(readLine());
	}

	public int getPlayingNumber() {
		return playingNumber.getPlayingNumber();
	}

	public List<Integer> getPlayingNumbers() {
		return playingNumber.getPlayingNumbers();
	}

}
