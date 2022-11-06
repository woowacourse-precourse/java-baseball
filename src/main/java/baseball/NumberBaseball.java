package baseball;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseball {

    private final static int MIN_NUM = 1;
    private final static int MAX_NUM = 9;
    private final static int ARRAY_SIZE = 3;

    ArrayList<Integer> targetNumbers = new ArrayList<>();

    public void createTargetNumberList() {
        while (targetNumbers.size() < ARRAY_SIZE) {
            overlapNumberInNumberList(Randoms.pickNumberInRange(MIN_NUM,MAX_NUM));
        }
    }

    private void overlapNumberInNumberList(int number) {
        if(targetNumbers.contains(number)) {
            return;
        }

        targetNumbers.add(number);
    }

}
