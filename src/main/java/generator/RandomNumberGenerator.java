package generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    public static int getNumber() { // 1 ~ 9 사이의 랜덤한 수 1개를 발생시킴
        return Randoms.pickNumberInRange(1, 9);
    }
}
