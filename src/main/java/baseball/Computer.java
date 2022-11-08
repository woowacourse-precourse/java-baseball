package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerAnswer;

    public Computer() {
        this.computerAnswer = new ArrayList<>();
    }

    public int createNumber(){
        return Randoms.pickNumberInRange(Range.RANGE_MIN, Range.RANGE_MAX);
    }

    public List<Integer> decideAnswer() {
        while (computerAnswer.size() < Range.DIGIT) {
            int randomNum = createNumber();
            addNum(randomNum);
        }
        return computerAnswer;
    }

    public void addNum(int randomNum) {
        if (!checkDuplicateNum(randomNum))
            computerAnswer.add(randomNum);
    }

    public boolean checkDuplicateNum(int num) {
        return computerAnswer.contains(num);
    }
}
