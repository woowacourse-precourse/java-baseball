package baseball.validator;

import java.util.List;
import java.util.stream.Collectors;

public class BallValidator {

	public static void validateDuplicate(List<Integer> balls) throws IllegalArgumentException {
		List<Integer> deDuplicatedBalls = balls.stream().distinct().collect(Collectors.toList());
		if (deDuplicatedBalls.size() != balls.size()) {
			throw new IllegalArgumentException();
		}
	}
}
