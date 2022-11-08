package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final String ERROR_MESSAGE_THREE_DIGITS = "3자리 숫자를 입력해주세요.";
    private final String ERROR_MESSAGE_DUPLICATE_NUMBER = "각각 다른 숫자를 입력해주세요.";

    private List<Number> numbers = new ArrayList<>();

    public Numbers(int input) {
        validateThreeDigits(input);
        validateDuplicateNumber(input);
        createNumberList(input);
    }

    private void validateThreeDigits(int input) {
        if ((input < 111) || (input > 999)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_THREE_DIGITS);
        }
    }

    private void validateDuplicateNumber(int input) {
        if (checkDuplicateNumber(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBER);
        }
    }

    private boolean checkDuplicateNumber(int input){
        int firstNumberInt = input/100;
        int secondNumberInt = input%100/10;
        int thirdNumberInt = input%10;

        return (firstNumberInt == secondNumberInt)
                ||(secondNumberInt == thirdNumberInt)
                ||(thirdNumberInt == firstNumberInt);
    }

    private void createNumberList(int input) {
        for (int exponent = 2; exponent >= 0; exponent--) {
            int decimalNumber = (int) Math.pow(10, exponent);
            int number = input / decimalNumber;

            addNumber(number);

            input = input % decimalNumber;
        }
    }

    private void addNumber(int numberInt) {
        Number number = Number.createNumber(numberInt);
        numbers.add(number);
    }

    public Number findNumber(int index) {
        return numbers.get(index);
    }
}
