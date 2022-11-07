package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {
    private static List<Integer> answerNumber;

    public void generateNewRandomAnswer() {
        answerNumber = new ArrayList<>();
        while (answerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }
        if(!isValidNumber(answerNumber))
            throw new IllegalArgumentException();
    }

    private boolean isValidNumber(List<Integer> numbers) {
        for(Integer number: numbers) {
            int overlapCnt = Collections.frequency(numbers, number);
            if(overlapCnt > 1)
                return false;
            if(number < 1 || number > 9)
                return false;
        }
        return true;
    }
}
