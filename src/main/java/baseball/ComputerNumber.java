package baseball;

import java.util.List;

public class ComputerNumber {

    private static final int NUMBER_LENGTH = 3;
    private List<Character> numberList;

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
