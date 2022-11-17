package baseball.random;

import camp.nextstep.edu.missionutils.Randoms;

public class Random {
    public static int randomIntegerCreatorFromArgs1ToArgs2(int startInclusiveInteger, int finishInclusiveInteger) {
        return Randoms.pickNumberInRange(startInclusiveInteger, finishInclusiveInteger);
    }
}
