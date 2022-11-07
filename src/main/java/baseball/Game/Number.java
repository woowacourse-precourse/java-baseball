package baseball.Game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Number {
    public Number() {

    }
    public int[] getRandomNum(final int len, final int MIN_NUM, final int MAX_NUM) {
        int [] arrNum = new int[2];

        for (int i = 0; i < len; i++){
            arrNum[i] = Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
        }

        return arrNum;
    }

}
