package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.Random;

public class Computer {
    private static List<Integer> computerAnswer;

    public static int createNumber(){
        return Randoms.pickNumberInRange(1, 9);
    }

    public List<Integer> decideAnswer() {
        while (computerAnswer.size() <= 3) {
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
