package baseball.Game;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    final int NUM_LEN = 3;

    public Number() {

    }

    public int [] getRandomNum(final int len, final int MIN_NUM, final int MAX_NUM) {
        int[] num = new int[NUM_LEN];

        for (int i = 0; i < len; i++){
            num[i] = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        }
        return num;
    }

}
