package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Referee {
	private static final int PLAYING_NUMBER_SIZE = 3;
	private final List<Integer> pitcherPlayingNumbers;
	private final List<Integer> batterPlayingNumbers;

	public Referee(Pitcher pitcher, Batter batter) {
		this.pitcherPlayingNumbers = pitcher.getPlayingNumbers();
		this.batterPlayingNumbers = batter.getPlayingNumbers();
	}

	public Referee(List<Integer> pitcherPlayingNumbers, List<Integer> batterPlayingNumbers) {
		this.pitcherPlayingNumbers = pitcherPlayingNumbers;
		this.batterPlayingNumbers = batterPlayingNumbers;
	}

	public String getResultMessage() {
		if (pitcherPlayingNumbers.equals(batterPlayingNumbers)) {
			return "3스트라이크";
		}
		// 스트라이크 개수 메서드
		int numberOfStrikes = getNumberOfStrikes();
		// 볼 개수 메서드
		int numberOfBalls = getNumberOfBalls(numberOfStrikes);
		//리턴 볼이 0일때, 스트라이크가 0일때 낫싱일때
		return judgeResult(numberOfBalls, numberOfStrikes);
	}

	private int getNumberOfStrikes() {
		int numberOfStrikes = 0;
		for (int i = 0; i < PLAYING_NUMBER_SIZE; i++) {
			numberOfStrikes += addNumberOfStrikes(i);
		}
		return numberOfStrikes;
	}

	private int addNumberOfStrikes(int i) {
		if (pitcherPlayingNumbers.get(i).equals(batterPlayingNumbers.get(i))) {
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
			return "낫싱";
		}
		if (numberOfBalls == 0) {
			return String.format("%d스트라이크", numberOfStrikes);
		}
		if (numberOfStrikes == 0) {
			return String.format("%d볼", numberOfBalls);
		}
		return String.format("%d볼 %d스트라이크", numberOfBalls, numberOfStrikes);
	}
}
