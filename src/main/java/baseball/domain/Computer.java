package baseball.domain;

import baseball.status.Constants;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private List<Integer> computerNumbers;

    public Computer() {
        computerInit();
    }

    public void computerInit() {
        computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < Constants.NUMBER_OF_DIGITS.getNumber()) {
            addRandomNumber(getRandomNumber());
        }
    }

    private void addRandomNumber(int randomNumber) {
        if (isNotDuplicateNumber(randomNumber)) {
            computerNumbers.add(randomNumber);
        }
    }

    private boolean isNotDuplicateNumber(int randomNumber) {
        return !computerNumbers.contains(randomNumber);
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(
                Constants.MIN_RANGE_OF_DIGITS.getNumber(),
                Constants.MAX_RANGE_OF_DIGITS.getNumber()
        );
    }

    public List<Integer> getComputerNumbers() {
        return computerNumbers;
    }
}
