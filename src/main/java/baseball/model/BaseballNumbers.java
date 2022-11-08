package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
    private static final int BASEBALL_NUMBER_LENGTH = 3;
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;
    private static final String NUMBER_LENGTH_ERROR_MESSAGE = "야구 게임 번호 길이를 초과하였습니다.";
    private static final String NUMBER_RANGE_ERROR_MESSAGE = "야구 게임을 위한 숫자 범위를 초과했습니다.";
    private static final String NUMBER_DUPLICATED_ERROR_MESSAGE = "야구 게임을 위한 숫자에 중복된 값을 입력하였습니다.";
    private final List<Integer> baseballNumbers;

    public BaseballNumbers() {
        this.baseballNumbers = new ArrayList<>();

        while (baseballNumbers.size() < BASEBALL_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);

            if (!baseballNumbers.contains(randomNumber)) {
                baseballNumbers.add(randomNumber);
            }
        }
    }

    public BaseballNumbers(String userInput) {
        if (userInput.length() != BASEBALL_NUMBER_LENGTH) {
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR_MESSAGE);
        }

        this.baseballNumbers = new ArrayList<>();

        for (char currChar : userInput.toCharArray()) {
            int currNum = currChar - '0';

            if (currNum < MIN_BASEBALL_NUMBER || currNum > MAX_BASEBALL_NUMBER) {
                throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
            } else if (this.baseballNumbers.contains(currNum)) {
                throw new IllegalArgumentException(NUMBER_DUPLICATED_ERROR_MESSAGE);
            }

            this.baseballNumbers.add(currNum);
        }
    }

    public int getNumber(int index) {
        return this.baseballNumbers.get(index);
    }

    public boolean containsNumber(int number) {
        return this.baseballNumbers.contains(number);
    }

    public List<Integer> getComparedResult(BaseballNumbers toCompare) {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
            int currNum = this.baseballNumbers.get(i);

            if (toCompare.getNumber(i) == currNum) {
                strikeCnt++;
            } else if (toCompare.containsNumber(currNum)) {
                ballCnt++;
            }
        }

        return List.of(ballCnt, strikeCnt);
    }
}
