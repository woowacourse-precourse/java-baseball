package baseball.computer;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class ComputerFunction {

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean collectionListCheckValue(int value, List<Integer> list) {
        return list.contains(value);
    }
}
