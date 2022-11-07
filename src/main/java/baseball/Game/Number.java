package baseball.Game;

import camp.nextstep.edu.missionutils.Randoms;

public class Number {
    static final int MAX_NUM = 9;
    static final int MIN_NUM = 1;

    public int getRandomNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }
}
