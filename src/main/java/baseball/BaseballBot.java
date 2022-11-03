package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballBot {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    private static final int NUM_LENGTH = 3;

    private int answer;

    //TODO: unique한 값인지 확인
    public void createRandomValue() {
        StringBuilder randomNumber = new StringBuilder();
        List<Integer> randomUniqueDigits = Randoms.pickUniqueNumbersInRange(START_RANGE, END_RANGE, NUM_LENGTH);

        for (int randomUniqueDigit : randomUniqueDigits) {
            randomNumber.append(randomUniqueDigit);
        }

        answer = Integer.parseInt(randomNumber.toString());
        answer++;
    }//서로
}
