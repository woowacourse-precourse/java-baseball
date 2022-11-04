package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Referee {
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
		// 볼 개수 메서드
		int numberOfBalls = getNumberOfBalls();
		// 스트라이크 개수 메서드
		int numberOfStrikes = getNumberOfStrikes();
		//리턴 볼이 0일때, 스트라이크가 0일때 낫싱일때
		return judgeResult(numberOfBalls, numberOfStrikes);
	}

	private int getNumberOfStrikes() {
		int numberOfStrikes = 0;
		for (int i = 0; i < 3; i++) {
			if (pitcherPlayingNumbers.get(i).equals(batterPlayingNumbers.get(i))) {
				numberOfStrikes++;
			}
		}
		return numberOfStrikes;
	}

	private int getNumberOfBalls() {
		Set<Integer> ballNumbers = pitcherPlayingNumbers
			.stream()
			.filter(batterPlayingNumbers::contains)
			.collect(Collectors.toSet());
		return ballNumbers.size();
	}

	private String judgeResult(int numberOfBalls, int numberOfStrikes) {
		if (numberOfBalls - numberOfStrikes == 0 && numberOfStrikes == 0) {
			return "낫싱";
		}
		if (numberOfBalls - numberOfStrikes == 0) {
			return String.format("%d스트라이크", numberOfStrikes);
		}
		if (numberOfStrikes == 0) {
			return String.format("%d볼", numberOfBalls);
		}
		return String.format("%d볼 %d스트라이크", (numberOfBalls - numberOfStrikes), numberOfStrikes);
	}
}
