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

    public boolean checkComputerGameOptionNumberBetweenOneAndTwo(String ComputerGameOptionNumber)
            throws IllegalArgumentException {
        if (!ComputerGameOptionNumber.equals(Constant.COMPUTER_GAME_RESTART) && !ComputerGameOptionNumber.equals(
                Constant.COMPUTER_GAME_EXIT)) {
            throw new IllegalArgumentException("1, 2 외의 숫자를 입력하셨습니다.");
        }
        return true;
    }

    public boolean checkComputerGameOptionNumberAboutOnlyOneAndTwo(String ComputerGameOptionNumber)
            throws IllegalArgumentException {
        if (!ComputerGameOptionNumber.matches(Constant.COMPUTER_OPTION)) {
            throw new IllegalArgumentException("숫자만 입력해주세요. ");
        }
        return true;
    }

}
