package baseball.domain;

import baseball.exception.DuplicateNumberException;
import baseball.exception.IncludeNotDigitException;
import baseball.exception.InvalidNumberLengthException;

import java.util.HashMap;
import java.util.Map;

public class InputValidation {

    /**
     * 중복된 숫자가 있는지 확인
     * @param number
     * @return 중복된 숫자가 하나라도 있으면 true, 없으면 DuplicateNumberException
     */
    public boolean checkIncludeDuplicateNumber(String number){
        Map<Character, Integer> numbers = new HashMap();

        if(number.chars().mapToObj(c -> (char)c)
                .map(c -> numbers.putIfAbsent(c, 1))
                .anyMatch(o -> o != null)) {

            throw new DuplicateNumberException("중복된 숫자가 존재하면 안됩니다.");
        } else {
            return false;
        }

    }

    /**
     * 숫자로만 이루어져 있는지 확인
     * @param number
     * @return 숫자로만 이루어져 있으면 true, 하나라도 숫자가 아니면 IncludeNotDigitException
     */
    public boolean checkContainOnlyDigit(String number) {

        if(number.length() == number.chars().mapToObj(c -> (char)c)
                              .filter(Character :: isDigit)
                              .count()) {

            return true;
        } else {
            throw new IncludeNotDigitException("숫자로만 이루어져 있어야 합니다.");
        }
    }


    /**
     * 숫자가 3자리로 이루어져 있는지 확인
     * @param number
     * @return 3자리면 true, 아니면 InvalidNumberLengthException
     */
    public boolean checkValidNumberLength(String number) {

        if(number.length() != 3) {
            throw new InvalidNumberLengthException("3자리 숫자로 이루어져 있어야 합니다.");
        } else {
            return true;
        }

    }

    /**
     * 모든 입력값 검증 요구사항을 만족하는지 확인
     * @param number
     * @return 모두 만족하면 true, 하나라도 틀리면 틀린 검증 요구사항에 해당하는 Exception Throw
     */
    public boolean checkAllValidation(String number) {
        return !checkIncludeDuplicateNumber(number) && checkContainOnlyDigit(number) && checkValidNumberLength(number);
    }

}
