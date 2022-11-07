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

    public boolean checkUserInputNumberBetweenOneAndNine(String userInputNumber) throws IllegalArgumentException {
        for (int i = 0; i < Constant.MAX_NUMBER_SIZE; i++) {
            if (userInputNumber.charAt(i) - '0' < Constant.USER_MIN_NUMBER
                    || userInputNumber.charAt(i) - '0' > Constant.USER_MAX_NUMBER) {
                throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
            }
        }
        return true;
    }

    public boolean checkUserInputNumberAboutOnlyNumber(String userInputNumber) throws IllegalArgumentException {
        if (!userInputNumber.matches(Constant.USER_NUMBER_OPTION)) {
            throw new IllegalArgumentException("숫자로만 입력해주세요. ");
        }
        return true;
    }

    public boolean checkDuplicatedUserInputNumber(String userInputNumber) throws IllegalArgumentException {
        Set<Character> UserNumberList = new HashSet<>();

        for (int i = 0; i < userInputNumber.length(); i++) {
            UserNumberList.add(userInputNumber.charAt(i));
        }
        if (UserNumberList.size() != userInputNumber.length()) {
            throw new IllegalArgumentException("숫자가 중복됩니다. ");
        }
        return true;
    }

    public boolean checkLengthOfUserInputNumber(String userInputNumber) throws IllegalArgumentException {
        if (userInputNumber.length() != 3) {
            throw new IllegalArgumentException("세개의 숫자만 입력해주세요. ");
        }
        return true;
    }


}
