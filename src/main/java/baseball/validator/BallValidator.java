package baseball.validator;

import static baseball.constant.Constants.*;

import java.util.List;
import java.util.stream.Collectors;

public class BallValidator {

	public static void validateDuplicate(List<Integer> balls) throws IllegalArgumentException {
		List<Integer> deDuplicatedBalls = balls.stream().distinct().collect(Collectors.toList());
		if (deDuplicatedBalls.size() != balls.size()) {
			throw new IllegalArgumentException();
		}
	}

	public static void validateNumberOfBalls(List<Integer> balls) {
		if (balls.size() != NUMBER_OF_BALLS_FOR_BASEBALL_GAME) {
			throw new IllegalArgumentException();
		}
	}
}
