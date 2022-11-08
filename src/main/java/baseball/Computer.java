package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int LENGTH = 3;
    private final int STARTRANGE = 1;
    private final int FINISHRANGE = 9;
    private List<Integer> computer;
    private int randomNum;

    public List<Integer> randomNumbers() {
        computer = new ArrayList<>();
        while (computer.size() < LENGTH) {
            randomNum = Randoms.pickNumberInRange(STARTRANGE, FINISHRANGE);
            computer = isContainNumber();
        }
        return computer;
    }

    public List<Integer> isContainNumber() {
        if (!computer.contains(randomNum)) {
            computer.add(randomNum);
        }
        return computer;
    }

}
