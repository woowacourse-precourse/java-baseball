package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer extends Player {

    public Computer() {
        setNums(Randoms.pickUniqueNumbersInRange(1, 9, 3));
    }

    @Override
    public String toString() {
        return "Computer"+super.toString();
    }
}
