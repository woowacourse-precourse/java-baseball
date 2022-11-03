package baseball.utils;

import baseball.domain.Ball;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserInputConvertor {
    public static List<Ball> mapToBalls(List<Integer> ballsBeforeMap) {
        UserInputValidator.isValidBalls(ballsBeforeMap);
        return IntStream.range(0, UserInputValidator.INPUT_SIZE)
                .mapToObj(index -> new Ball(index + 1, ballsBeforeMap.get(index)))
                .collect(Collectors.toList());
    }

    public static List<Integer> mapToInt(String userInput) {
        List<Integer> balls = new ArrayList<>();
        for (char ballNo : userInput.toCharArray()) {
            balls.add(charToInt(ballNo));
        }
        return balls;
    }

    private static int charToInt(char ballNo) {
        UserInputValidator.isValidBallNo(ballNo);
        return ballNo - '0';
    }
}
