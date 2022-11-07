package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.logging.Logger;


public class Game {
    private final static Logger LOG = Logger.getGlobal();
    int num1, num2, num3;
    Randoms Ran;

    public Game() {
        List<Integer> numberList = Ran.pickUniqueNumbersInRange(1, 9, 3);
        this.num1 = numberList.get(0);
        this.num2 = numberList.get(1);
        this.num3 = numberList.get(2);
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }

    public int getNum3() {
        return num3;
    }
}
