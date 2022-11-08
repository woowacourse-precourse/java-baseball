package baseball;

import java.util.ArrayList;
import java.util.List;


public class ResultValidator {
    public List<Integer> validate(String input, String createdNumber) {
        List<Integer> result = new ArrayList<>();
        int strike = countStrike(input, createdNumber);
        int ball = countBall(input, createdNumber);
        result.add(strike);
        result.add(ball);

        return result;
    }

    private int countStrike(String input, String createdNumber) {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == createdNumber.charAt(i)) {
                strike = strike + 1;
            }
        }
        return strike;
    }

    private int countBall(String input, String createdNumber) {
        int ball = 0;
        String[] chars = input.split("");
        for (String eachChar : chars) {
            if (createdNumber.contains(eachChar)) {
                ball = ball + 1;
            }
        }
        ball = ball - countStrike(input, createdNumber);

        return ball;
    }
}
