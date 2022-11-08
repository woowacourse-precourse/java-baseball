package generator;

import camp.nextstep.edu.missionutils.Randoms;

class RandomNumberGenerator {
    public static int getNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }
}
