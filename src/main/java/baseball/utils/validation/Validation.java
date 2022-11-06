package baseball.utils.validation;

import java.util.ArrayList;
import java.util.List;

public class Validation {

    public String validatePlayerNumbers(String playersNumber) {


        List<Integer> digitNumbers = digitNumbersList(playersNumber);

        isListLengthEqualsThree(digitNumbers);

        validateNumberContainsZero(digitNumbers);

        validateDuplicateNumber(digitNumbers);

        return playersNumber;
    }
    private List<Integer> validateNumbers(String[] playersNumberArr,List<Integer> digitNumbers) {

        for(String playersNumber : playersNumberArr) {
            try {
                int number = Integer.parseInt(playersNumber);
                digitNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("숫자만 입력 가능합니다.");
            }
        }
        return digitNumbers;
    }

    private List<Integer> digitNumbersList(String playersNumber) {
        List<Integer> digitNumbers = new ArrayList<>();
        String[] playersNumberArr = playersNumber.split("");

        return validateNumbers(playersNumberArr, digitNumbers);
    }
    private void isListLengthEqualsThree(List<Integer> digitNumbers) {
        if(digitNumbers.size() != 3) {
            throw new IllegalArgumentException("세자리 숫자만 입력 가능합니다.");
        }
    }

    private void validateNumberContainsZero(List<Integer> digitNumbers) {
        if(digitNumbers.contains(0)) {
            throw new IllegalArgumentException("각 자릿수는 1-9 사이입니다.");
        }
    }

    private void validateDuplicateNumber(List<Integer> digitNumbers) {
        for(int digitNumber = 0; digitNumber< digitNumbers.size()-1; digitNumber++) {
            for(int digitNumber2 = digitNumber+1; digitNumber2<digitNumbers.size();digitNumber2++) {
                throwWhenDuplicateNumber(digitNumbers.get(digitNumber), digitNumbers.get(digitNumber2) );
            }
        }
    }

    private void throwWhenDuplicateNumber(int number1, int number2) {
        if(number1 == number2) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }

}
