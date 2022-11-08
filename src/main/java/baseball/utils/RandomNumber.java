package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class RandomNumber {

    public int[] getRandomNumber() {
        int[] computerNumber = new int[3];
        for (int i = 0; i < 3; i ++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!Arrays.asList(computerNumber).contains(computerNumber[i])) {
                computerNumber[i] = randomNumber;
            }
        }
        return computerNumber;
    }
}
