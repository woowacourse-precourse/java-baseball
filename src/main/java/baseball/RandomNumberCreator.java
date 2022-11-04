package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberCreator {
    public static int createRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
