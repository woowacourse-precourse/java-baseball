package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Random {
    static final int NUMBER_OF_DIGIT = 3;

    public static int getRandomNum() {
        List<Integer> randomNumList;

        while(true){
            randomNumList = Randoms.pickUniqueNumbersInRange(0, 9, NUMBER_OF_DIGIT);
            if(isValidateDigitNum(randomNumList)){
                break;
            }
        }

        int randomNum = numListToIntValue(randomNumList);

        return randomNum;
    }

    public static int numListToIntValue(List<Integer> numList){
        int listSize = numList.size();
        int resultNum = 0;

        for (int i = 0; i < listSize; i++) {
            resultNum += numList.get(i) * Math.pow(10, listSize - i - 1);
        }

        return resultNum;
    }

    public static boolean isValidateDigitNum(List<Integer> numList){
        int firstDigit = numList.get(0);

        if(firstDigit == 0){
            return false;
        }
        return true;
    }
}
