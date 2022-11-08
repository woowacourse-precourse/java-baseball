package baseball;

import java.util.ArrayList;
import java.util.List;

import static baseball.Constants.ANSWER_NUM_CNT;
import static baseball.Constants.ANSWER_NUM_RANGE_START;
import static baseball.Constants.ANSWER_NUM_RANGE_END;
import static baseball.Constants.GAME_OVER_NO;
import static baseball.Constants.GAME_OVER_YES;

import static baseball.Constants.ONLY_NUMBER_EXCEPTION;
import static baseball.Constants.NUMBER_LENGTH_EXCEPTION;
import static baseball.Constants.NUMBER_RANGE_EXCEPTION;
import static baseball.Constants.NUMBER_DUPLICATE_EXCEPTION;
import static baseball.Constants.OVER_YN_EXCEPTION;

public class Vailidator {

    public static void checkInputNum(String inputNumStr) {
        checkOnlyNumber(inputNumStr);
        checkInputNumLength(inputNumStr);
        checkInputNumRange(inputNumStr);
        checkDuplicatedNum(inputNumStr);
    }

    public static void checkOnlyNumber(String inputNumStr) {
        try {
            int inputNum = Integer.parseInt(inputNumStr);
        } catch (Exception e) {
            throw new IllegalArgumentException(ONLY_NUMBER_EXCEPTION);
        }
    }

    public static void checkInputNumLength(String inputNumStr) {
        if (inputNumStr.length() != ANSWER_NUM_CNT) {
            throw new IllegalArgumentException(NUMBER_LENGTH_EXCEPTION);
        }
    }

    public static void checkInputNumRange(String inputNumStr) {
        String[] numArr = inputNumStr.split("");
        for (String s : numArr) {
            int num = Integer.parseInt(s);
            if (num < ANSWER_NUM_RANGE_START || num > ANSWER_NUM_RANGE_END) {
                throw new IllegalArgumentException(NUMBER_RANGE_EXCEPTION);
            }
        }
    }

    public static void checkDuplicatedNum(String inputNumStr) {
        List<Integer> numList = new ArrayList<>();
        String[] numArr = inputNumStr.split("");
        for (String s : numArr) {
            int num = Integer.parseInt(s);
            if (numList.contains(num)) {
                throw new IllegalArgumentException(NUMBER_DUPLICATE_EXCEPTION);
            }
            numList.add(num);
        }
    }

    public static void checkInputOverYn(int overYnNum) {
        if (!(overYnNum == GAME_OVER_NO || overYnNum == GAME_OVER_YES)) {
            throw new IllegalArgumentException(OVER_YN_EXCEPTION);
        }
    }
}
