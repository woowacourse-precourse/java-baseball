package baseball.number;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class TargetNumber implements Number {
    final int START = 1;
    final int END = 9;
    List<String> targetNumber = new ArrayList<>();

    @Override
    public List<String> getNumber() {
        return targetNumber;
    }

    public void generateTargetNumber(){

        targetNumber = new ArrayList<>();

        while (targetNumber.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(START, END);
            String number = String.valueOf(randomNumber);

            if (!targetNumber.contains(number)) {
                targetNumber.add(number);
            }
        }
    }
}
