package baseball.baseballgame.ball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumber {

    static int createFrom1To9() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
