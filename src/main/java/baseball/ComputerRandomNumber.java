package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerRandomNumber {
    private final int LENGTH = 3;
    private final int STARTRANGE = 1;
    private final int FINISHRANGE = 9;
    private List<Integer> computer;

    public List<Integer> randomNumbers() {
        computer = new ArrayList<>();
        while (computer.size() < LENGTH) {
            int randomNum = Randoms.pickNumberInRange(STARTRANGE, FINISHRANGE);
            computer = isContainNumber(computer, randomNum);
        }
        return computer;
    }

    public List<Integer> isContainNumber(List<Integer> computer, int randomNum) {
        if (!computer.contains(randomNum)) {
            computer.add(randomNum);
        }
        return computer;
    }

}
