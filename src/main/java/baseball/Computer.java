package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static final int RANGE_START = 1;
    public static final int RANGE_END = 9;
    public static final int LENGTH_LIMIT = 3;
    private List<Integer> integerList = new ArrayList<>();

    public List<Integer> generateIntegerList() {
        List<Integer> integerList = new ArrayList<>();

        while (integerList.size() < LENGTH_LIMIT) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START, RANGE_END);
            if (!integerList.contains(randomNumber)) {
                integerList.add(randomNumber);
            }
        }

        return integerList;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }
}
