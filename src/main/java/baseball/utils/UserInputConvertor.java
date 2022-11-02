package baseball.utils;

import java.util.ArrayList;
import java.util.List;

public class UserInputConvertor {
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
