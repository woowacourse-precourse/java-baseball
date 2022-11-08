package generator;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator {
    /*
    * 1 ~ 9 사이의 수 중에서 랜덤하게 1개의 수를 int type으로 반환
    */
    public static int getNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
