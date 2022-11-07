package baseball.utils;

import baseball.domain.Ball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BallConvertor {
    public static List<Ball> mapToBalls(List<Integer> ballsBeforeMap) {
        BallValidator.isValidBalls(ballsBeforeMap);
        return IntStream.range(0, BallValidator.MAX_BALL_SIZE)
                .mapToObj(index -> new Ball(index + 1, ballsBeforeMap.get(index)))
                .collect(Collectors.toList());
    }

    public static List<Integer> mapToInt(String userInput) {
        return IntStream.range(0, userInput.length())
                .map(index -> charToInt(userInput.charAt(index)))
                .boxed()
                .collect(Collectors.toList());
    }

    private static int charToInt(char ballNo) {
        BallValidator.isValidBallNo(ballNo);
        return ballNo - '0';
    }
}
