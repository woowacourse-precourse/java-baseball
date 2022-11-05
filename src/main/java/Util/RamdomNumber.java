package Util;

import camp.nextstep.edu.missionutils.Randoms;

import static Constant.Const.MAX_NUMBER;
import static Constant.Const.MIN_NUMBER;

public class RamdomNumber {
    private int[] randomNumber;

    public RamdomNumber(int size){
        randomNumber = new int[size];
    }

    public int[] makeRandomNumber(int size) {
        boolean[] alreadyUsed = new boolean[MAX_NUMBER + 1];
        for (int i = 0; i < size; i++) {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

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
