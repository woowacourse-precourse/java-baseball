package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private static final int NUMBER_COUNT = 3;

    private final String ERROR_MESSAGE_THREE_DIGITS = "3자리 숫자를 입력해주세요.";
    private final String ERROR_MESSAGE_DUPLICATE_NUMBER = "각각 다른 숫자를 입력해주세요.";

    private final List<Number> numberList = new ArrayList<>();

    private Numbers() {
    }

    public static Numbers createNumbers(int input) {
        Numbers numbers = new Numbers();

        numbers.validateThreeDigits(input);
        numbers.validateDuplicateNumber(input);

        numbers.createNumberList(input);

        return numbers;
    }

    public static Numbers createRandomNumbers() {
        Numbers numbers = new Numbers();
        numbers.pickNewRandomNumbers();
        return numbers;
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
        for (int exponent = NUMBER_COUNT - 1; exponent >= 0; exponent--) {
            int decimalNumber = (int) Math.pow(10, exponent);
            int number = input / decimalNumber;

            addNumber(number);

            input = input % decimalNumber;
        }
    }

    private void addNumber(int numberInt) {
        Number number = Number.createNumber(numberInt);
        numberList.add(number);
    }


    private void pickNewRandomNumbers() {
        for (int index = 0; index < NUMBER_COUNT; index++) {
            numberList.add(newRandomNumber());
        }
    }

    private Number newRandomNumber() {
        Number newRandomNumber;
        //랜덤 숫자 중복 방지
        do {
            newRandomNumber = Number.createRandomNumber();
        } while (numberList.contains(newRandomNumber));
        return newRandomNumber;
    }

    public Number findNumber(int index) {
        return numberList.get(index);
    }
}
