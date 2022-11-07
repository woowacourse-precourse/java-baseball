package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class Pitcher {
	private final int PLAYING_NUMBER_SIZE = 3;
	private final int MIN_NUMBER = 1;
	private final int MAX_NUMBER = 9;

	private final PlayingNumber playingNumber;

	public Pitcher() {
		this.playingNumber = new PlayingNumber(make3DigitNumber());
	}

	public int getPlayingNumber() {
		return playingNumber.getPlayingNumber();
	}

	public List<Integer> getPlayingNumbers() {
		return playingNumber.getPlayingNumbers();
	}

	private String make3DigitNumber() {
		StringBuilder stringBuilder = new StringBuilder();
		List<Integer> prev = new ArrayList<>();

		while (stringBuilder.length() != PLAYING_NUMBER_SIZE) {
			int newNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

			if (!prev.contains(newNumber)) {
				stringBuilder.append(newNumber);
				prev.add(newNumber);
			}
		}

		return stringBuilder.toString();
	}

}
