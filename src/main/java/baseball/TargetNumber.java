package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TargetNumber {
    public static final int TARGET_NUMBER_LENGTH = 3;

    private final List<Integer> numberListByDigit;

    public static TargetNumber getRandomInstance() {
        return new TargetNumber();
    }

    private TargetNumber() {
        numberListByDigit = new ArrayList<>();
        while (numberListByDigit.size() < TARGET_NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberListByDigit.contains(randomNumber)) {
                numberListByDigit.add(randomNumber);
            }
        }

        Collections.reverse(numberListByDigit);
    }

    public TargetNumber(int number) throws IllegalArgumentException {
        this.numberListByDigit = new ArrayList<>();

        int numberLength = 0;
        for(int i = number; i > 0; i /= 10) {
            int currentDigit = i % 10;
            numberLength++;

            checkNumberLengthNotExceedTargetNumberLength(numberLength);
            checkDigitNonZero(currentDigit);
            checkDigitNotDuplicate(currentDigit);

            numberListByDigit.add(currentDigit);
        }
        checkExactNumberLength(numberLength);
    }

    public int toInt() {
        int result = 0;
        int digitLevel = 1;
        for(int i = 0; i < TARGET_NUMBER_LENGTH; i++) {
            result += numberListByDigit.get(i) * digitLevel;
            digitLevel *= 10;
        }

        return result;
    }

    public BallStrikeResult compareTo(TargetNumber oth) {
        BallStrikeResult result = new BallStrikeResult();
        for(int i = 0; i < this.numberListByDigit.size(); i++) {
            for(int j = 0; j < oth.numberListByDigit.size(); j++) {
                countBallOrStrike(
                        result,
                        this.numberListByDigit.get(i),
                        oth.numberListByDigit.get(j),
                        i == j
                );
            }
        }
        return result;
    }

    private void countBallOrStrike(BallStrikeResult result, int digit1, int digit2, boolean isStrike) {
        if(digit1 == digit2) {
            if(isStrike) {
                result.addStrikeCount();
                return;
            }
            result.addBallCount();
        }
    }

    private void checkNumberLengthNotExceedTargetNumberLength(int numberLength) {
        if (numberLength > TARGET_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDigitNonZero(int currentDigitRemain) {
        if (currentDigitRemain == 0) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDigitNotDuplicate(int currentDigitRemain) {
        if(numberListByDigit.contains(currentDigitRemain)) {
            throw new IllegalArgumentException();
        }
    }

    private void checkExactNumberLength(int numberLength) {
        if (numberLength != TARGET_NUMBER_LENGTH) {
            throw new IllegalArgumentException();
        }
    }
}
