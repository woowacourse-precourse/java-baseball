package baseball.ball;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class BallNumber {
	private final static int MIN_BALL_NUMBER = 1;
	private final static int MAX_BALL_NUMBER = 9;

	private static final Map<Integer, BallNumber> ballNumberCache = new HashMap<>();

	static {
		IntStream.rangeClosed(MIN_BALL_NUMBER, MAX_BALL_NUMBER)
			.forEach(number -> ballNumberCache.put(number, new BallNumber(number)));
	}
	private final int number;

	public BallNumber(int number) {
		this.number = number;
	}

	private static void validateBallNumber(int number) {
		if (!ballNumberCache.containsKey(number)) {
			throw new IllegalArgumentException("1~9 범위의 숫자를 입력해주세요.");
		}
	}

	public static BallNumber from(int number) {
		validateBallNumber(number);
		return ballNumberCache.get(number);
	}

	public int getNumber() {
		return number;
	}
}
