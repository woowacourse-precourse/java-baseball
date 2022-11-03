package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pitcher {
	private static final int PITCHING_NUMBER_SIZE = 3;
	private final List<Integer> pitchingNumbers;

	public Pitcher(List<Integer> pitchingNumbers) {
		validateSize(pitchingNumbers);
		validateDuplicate(pitchingNumbers);
		this.pitchingNumbers = pitchingNumbers;
	}

	private void validateSize(List<Integer> pitchingNumbers) {
		if(pitchingNumbers.size() != PITCHING_NUMBER_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	private void validateDuplicate(List<Integer> pitchingNumbers) {
		Set<Integer> nonDuplicateNumbers = new HashSet<>(pitchingNumbers);
		if(nonDuplicateNumbers.size() != PITCHING_NUMBER_SIZE) {
			throw new IllegalArgumentException();
		}
	}

	public List<Integer> getPitchingNumbers() {
		return pitchingNumbers;
	}
}
