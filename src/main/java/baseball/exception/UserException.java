package baseball.exception;

import baseball.domain.Constant;
import java.util.HashSet;
import java.util.Set;

public class UserException {

    public boolean checkUserExceptions(String userInputNumber) {
        if (checkDuplicatedUserInputNumber(userInputNumber) && checkUserInputNumberAboutOnlyNumber(userInputNumber)
                && checkUserInputNumberBetweenOneAndNine(userInputNumber)
                && checkLengthOfUserInputNumber(userInputNumber)) {
            return true;
        }
        return false;
    }


}
