package baseball.domain;

import java.util.List;

public class BaseballGameCalculator {
    private static int ball = 0;
    private static int strike = 0;

    /**
     * @param number1 야구게임 계산할 baseballNumber
     * @param number2 야구게임 계산할 baseballNumber
     * @return 야구게임결과를 반환하는 BaseballGameResult
     */
    public static BaseballGameResult calculateBallStrikeCount(BaseballNumber number1, BaseballNumber number2) {
        clearCalculator();
        List<Integer> numbers1 = number1.getNumbers();
        List<Integer> numbers2 = number2.getNumbers();

        for (int i = 0; i < BaseballNumber.DIGIT; i++) {
            if (numbers1.get(i).equals(numbers2.get(i))) {
                strike += 1;
                continue;
            }
            if (numbers2.contains(numbers1.get(i))) {
                ball += 1;
            }
        }

        return new BaseballGameResult(ball, strike);
    }

    private static void clearCalculator() {
        ball = 0;
        strike = 0;
    }
}