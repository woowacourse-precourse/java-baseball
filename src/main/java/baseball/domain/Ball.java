package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Ball {

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
