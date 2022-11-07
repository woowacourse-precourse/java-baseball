package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Referee {
	private final int PLAYING_NUMBER_SIZE = 3;
	private final String STRIKE_MESSAGE = "%d스트라이크";
	private final String BALL_MESSAGE = "%d볼";
	private final String BALL_STRIKE_MESSAGE = "%d볼 %d스트라이크";
	private final String NOTHING_MESSAGE = "낫싱";

	private final List<Integer> pitcherPlayingNumbers;
	private final List<Integer> batterPlayingNumbers;

	public Referee(Pitcher pitcher, Batter batter) {
		this.pitcherPlayingNumbers = pitcher.getPlayingNumbers();
		this.batterPlayingNumbers = batter.getPlayingNumbers();
	}

	public Referee(List<Integer> firstTestNumbers, List<Integer> secondTestNumbers) {
		this.pitcherPlayingNumbers = firstTestNumbers;
		this.batterPlayingNumbers = secondTestNumbers;
	}

	public String getResultMessage() {
		if (pitcherPlayingNumbers.equals(batterPlayingNumbers)) {
			return String.format(STRIKE_MESSAGE, PLAYING_NUMBER_SIZE);
		}

		int numberOfStrikes = getNumberOfStrikes();
		int numberOfBalls = getNumberOfBalls(numberOfStrikes);

		return judgeResult(numberOfBalls, numberOfStrikes);
	}

	private int getNumberOfStrikes() {
		int numberOfStrikes = 0;
		for (int i = 0; i < PLAYING_NUMBER_SIZE; i++) {
			numberOfStrikes += addNumberOfStrikes(i);
		}
		return numberOfStrikes;
	}

	private int addNumberOfStrikes(int index) {
		if (pitcherPlayingNumbers.get(index).equals(batterPlayingNumbers.get(index))) {
			return 1;
		}
		return 0;
	}

	private int getNumberOfBalls(int numberOfStrikes) {
		Set<Integer> ballNumbers = pitcherPlayingNumbers
			.stream()
			.filter(batterPlayingNumbers::contains)
			.collect(Collectors.toSet());

		if (ballNumbers.size() < numberOfStrikes) {
			return 0;
		}
		return ballNumbers.size() - numberOfStrikes;
	}

	private String judgeResult(int numberOfBalls, int numberOfStrikes) {
		if (numberOfBalls == 0 && numberOfStrikes == 0) {
			return NOTHING_MESSAGE;
		}
		if (numberOfBalls == 0) {
			return String.format(STRIKE_MESSAGE, numberOfStrikes);
		}
		if (numberOfStrikes == 0) {
			return String.format(BALL_MESSAGE, numberOfBalls);
		}
		return String.format(BALL_STRIKE_MESSAGE, numberOfBalls, numberOfStrikes);
	}
}
