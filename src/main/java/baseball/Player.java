package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
	private static final int PLAYING_NUMBER_SIZE = 3;
	private static final int NUMBER_OF_EXCEPTION = 0;

	private final List<Integer> playingNumbers;

	public Player(List<Integer> playingNumbers) {
		validateSize(playingNumbers);
		validateDuplicate(playingNumbers);
		validateZeroException(playingNumbers);
		this.playingNumbers = playingNumbers;
	}

	private void validateSize(List<Integer> playingNumbers) {
		if (playingNumbers.size() != PLAYING_NUMBER_SIZE) {
			throw new IllegalArgumentException("3자리 숫자만 입력해주세요.");
		}
	}

	private void validateDuplicate(List<Integer> playingNumbers) {
		Set<Integer> nonDuplicateNumbers = new HashSet<>(playingNumbers);
		if (nonDuplicateNumbers.size() != PLAYING_NUMBER_SIZE) {
			throw new IllegalArgumentException("서로 다른 숫자들만 입력해주세요.");
		}
	}

	private void validateZeroException(List<Integer> playingNumbers) {
		if (playingNumbers.contains(NUMBER_OF_EXCEPTION)) {
			throw new IllegalArgumentException("0은 포함될 수 없습니다.");
		}
	}

	public List<Integer> getPlayingNumbers() {
		return playingNumbers;
	}
}
