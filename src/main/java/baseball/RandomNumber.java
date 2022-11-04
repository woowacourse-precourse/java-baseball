package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomNumber {
    private int numberOfDigit;

    public RandomNumber(final int NUMBER_OF_DIGIT) {
        this.numberOfDigit = NUMBER_OF_DIGIT;
    }

    public int getRandomNum() {
        List<Integer> randomNumList;

        while (true) {
            randomNumList = Randoms.pickUniqueNumbersInRange(0, 9, numberOfDigit);
            if (isValidateDigitNum(randomNumList)) {
                break;
            }
        }

        int randomNum = numListToIntValue(randomNumList);

        return randomNum;
    }

    public int numListToIntValue(List<Integer> numList) {
        int listSize = numList.size();
        int resultNum = 0;

        for (int i = 0; i < listSize; i++) {
            resultNum += numList.get(i) * Math.pow(10, listSize - i - 1);
        }

        return resultNum;
    }

    public boolean isValidateDigitNum(List<Integer> numList) {
        int firstDigit = numList.get(0);

        if (firstDigit == 0) {
            return false;
        }
        return true;
    }
}
