package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import baseball.ball.BallNumber;
import baseball.ball.BallNumbers;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomAnswerBallNumberGenerator {
	private final static int NUMBER_OF_BALLS = 3;
	private final static int MIN_BALL_NUMBER = 1;
	private final static int MAX_BALL_NUMBER = 9;

	public static BallNumbers generate() {
		List<BallNumber> nonDuplicateNumbers = new ArrayList<>();

		while (nonDuplicateNumbers.size() != NUMBER_OF_BALLS) {
			BallNumber ballNumber = BallNumber.from(Randoms.pickNumberInRange(MIN_BALL_NUMBER, MAX_BALL_NUMBER));

			if (!nonDuplicateNumbers.contains(ballNumber)) {
				nonDuplicateNumbers.add(ballNumber);
			}
		}

		return BallNumbers.from(nonDuplicateNumbers);
	}
}
