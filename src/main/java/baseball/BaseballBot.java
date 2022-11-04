package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballBot {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int NUM_LENGTH = 3;

    private static final String STRIKE_STR = "스트라이크 ";
    private static final String BALL_STR = "볼 ";
    private static final String NOTHING_STR = "낫싱";

    private String answer;

    public void createRandomValue() {
        StringBuilder randomNumber = new StringBuilder();
        List<Integer> randomUniqueDigits = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, NUM_LENGTH);

        for (int randomUniqueDigit : randomUniqueDigits) {
            randomNumber.append(randomUniqueDigit);
        }

        answer = randomNumber.toString();
    }

    public String checkHint(String userInput) {
        int strike = getStrikeNum(userInput);
        int ball = getBallNum(userInput, strike);

        return createHintStr(strike, ball);
    }

    private int getStrikeNum(String userInput) {
        int strike = 0;

        for (int i = 0; i < NUM_LENGTH; i++) {
            if (answer.charAt(i) == userInput.charAt(i)) {
                strike++;
            }
        }

        return strike;
    }

    private int getBallNum(String userInput, int strike) {
        int sameNumberCount = 0;

        for (int i = 0; i < NUM_LENGTH; i++) {
            char curChar = userInput.charAt(i);

            if (answer.contains(String.valueOf(curChar))) {
                sameNumberCount++;
            }
        }

        //같은 숫자가 나오는 경우는 스트라이크이거나 볼일 경우 두 가지이다
        //따라서 (볼의 개수) = (같은 숫자의 개수) - (스트라이크 개수)
        return sameNumberCount - strike;
    }

    private String createHintStr(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            return NOTHING_STR;
        }

        return strike + STRIKE_STR + ball + BALL_STR;
    }
}
