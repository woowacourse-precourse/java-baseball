package Util;

import camp.nextstep.edu.missionutils.Randoms;

public class RamdomNumber {
    private int[] randomNumber;

    public RamdomNumber(int size){
        randomNumber = new int[size];
    }

    public int[] makeRandomNumber(int size) {
        boolean[] alreadyUsed = new boolean[10];
        for (int i = 0; i < size; i++) {
            int number = Randoms.pickNumberInRange(1, 9);

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
