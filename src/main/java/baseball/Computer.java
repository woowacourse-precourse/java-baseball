package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    private void addNonDuplicateNumber(List<Integer> computerNumbers, int randomNumber) {
        if (!computerNumbers.contains(randomNumber)) {
            computerNumbers.add(randomNumber);
        }
    }

    public List<Integer> initRandomNumber() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
            addNonDuplicateNumber(computerNumbers, randomNumber);
        }
        return computerNumbers;
    }
}
