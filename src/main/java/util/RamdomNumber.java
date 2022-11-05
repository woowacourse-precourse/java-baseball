package util;

import constant.Const;
import camp.nextstep.edu.missionutils.Randoms;

public class RamdomNumber {
    private int[] randomNumber;

    public RamdomNumber(int numberLength){
        randomNumber = new int[numberLength];
    }

    public int[] makeRandomNumber(int numberLength) {
        boolean[] alreadyUsed = new boolean[Const.MAX_NUMBER + 1];
        for (int i = 0; i < numberLength; i++) {
            int number = Randoms.pickNumberInRange(Const.MIN_NUMBER, Const.MAX_NUMBER);

            if (!alreadyUsed[number]) {
                alreadyUsed[number] = true;
                randomNumber[i] = number;
            } else {
                i--;
            }
        }
        return randomNumber;
    }
}
