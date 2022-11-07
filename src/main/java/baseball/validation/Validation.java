package baseball.validation;

import java.util.ArrayList;
import java.util.List;

import static baseball.number.game.Game.*;

public class Validation {

    static final int NUMBER_LENGTH = 3;
    static final int ZERO = 0;

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
                throw new IllegalArgumentException(ERROR_MESSAGE_ONLY_NUMBER.getValue());
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
        if(digitNumbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_LENGTH_THREE.getValue());
        }
    }

    private void validateNumberContainsZero(List<Integer> digitNumbers) {
        if(digitNumbers.contains(ZERO)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NUMBER_RANGE_ONE_TO_NINE.getValue());
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
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DUPLICATE.getValue());
        }
    }

}
