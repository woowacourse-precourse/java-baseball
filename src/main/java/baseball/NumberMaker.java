package baseball;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Randoms;

public class NumberMaker {
    public int makeNumberInRange(int min, int max) {
        return Randoms.pickNumberInRange(min, max);
    }
}
