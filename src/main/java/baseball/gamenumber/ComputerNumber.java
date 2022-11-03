package baseball.gamenumber;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerNumber extends GameNumber {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int NUMBER_DIGITS = 3;

    private final List<Integer> computerNumberList = new ArrayList<>(NUMBER_DIGITS);

    public ComputerNumber() {
    }

    public ComputerNumber(List<Integer> numberList) {
        super(numberList);
    }

    public int getRandomNumber() {
        return pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public List<Integer> getComputerNumberList() {
        int index = 0;
        while (index < NUMBER_DIGITS) {
            int randomNumber = this.getRandomNumber();
            if (isDuplicate(computerNumberList, randomNumber)) {
                continue;
            }
            if (!(isDuplicate(computerNumberList, randomNumber))) {
                computerNumberList.add(randomNumber);
                index++;
            }
        }
        return computerNumberList;
    }

    public boolean isDuplicate(List<Integer> computerNumberList, int randomNumber) {
        if (computerNumberList.contains(randomNumber)) {
            return true;
        }
        return false;
    }
}
