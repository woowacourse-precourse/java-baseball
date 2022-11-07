package baseball.domain;

import java.util.List;

public class BaseballGameCalculator {
    private static final int[] bsoResult = new int[2];
    private static final int BALL = 0;
    private static final int STRIKE = 1;

    /**
     * @param number1 야구게임 계산할 baseballNumber
     * @param number2 야구게임 계산할 baseballNumber
     * @return 야구게임의 결과를 담은 int형 배열  인덱스 0은 ball의 개수, 인덱스 1은 strike의 개수
     */
    public static int[] calculateBallStrikeCount(BaseballNumber number1, BaseballNumber number2) {
        clearBSOResult();
        List<Integer> numbers1 = number1.getNumbers();
        List<Integer> numbers2 = number2.getNumbers();

        for (int i = 0; i < BaseballNumber.DIGIT; i++) {
            if (numbers1.get(i).equals(numbers2.get(i))) {
                bsoResult[STRIKE] += 1;
                continue;
            }
            if (numbers2.contains(numbers1.get(i))) {
                bsoResult[BALL] += 1;
            }
        }

        return bsoResult.clone();
    }

    private static void clearBSOResult() {
        bsoResult[BALL] = 0;
        bsoResult[STRIKE] = 0;
    }
}