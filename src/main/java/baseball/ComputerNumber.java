package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    private static final int NUMBER_LENGTH = 3;
    private List<Character> numberList = new ArrayList<>();

    public ComputerNumber() {
        while (checkListLength(this.numberList)) {
            char randomNumber = Character.forDigit(Randoms.pickNumberInRange(1, 9), 10);;
            if (!checkListAlreadyContainNumber(randomNumber)) {
                this.numberList.add(randomNumber);
            }
        }
    }

    public List<Character> getNumberList() {
        return numberList;
    }

    private boolean checkListLength(List<Character> numberList) {
        if (numberList.size() < NUMBER_LENGTH) {
            return true;
        }
        return false;
    }

    private boolean checkListAlreadyContainNumber(Character tempNumber) {
        if (numberList.contains(tempNumber)) {
            return true;
        }
        return false;
    }

}
