package baseball.exception;

import baseball.domain.Computer;
import baseball.domain.Constant;

public class ComputerException {
    public boolean checkComputerExceptions(String ComputerGameOptionNumber) {
        if (checkComputerGameOptionNumberBetweenOneAndTwo(ComputerGameOptionNumber)
                && checkComputerGameOptionNumberAboutOnlyOneAndTwo(ComputerGameOptionNumber)) {
            return true;
        }
        return false;
    }


}
