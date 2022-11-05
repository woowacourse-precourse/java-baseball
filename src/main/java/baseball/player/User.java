package baseball.player;

import baseball.utils.NumberParsing;

import java.util.List;

public class User {

    private List<Integer> userNumbers;

    public void setUser(String inputNumbers) {
        this.userNumbers = createValidNumbers(inputNumbers);
    }

    private List<Integer> createValidNumbers(String inputNumbers) throws IllegalArgumentException {

        if (!NumberParsing.isNonZeroNumber(inputNumbers)) {
            throw new IllegalArgumentException();
        }

        List<Integer> numbers = NumberParsing.changeStringToIntegers(inputNumbers);

        if (!NumberParsing.isEqualToSetCount(numbers, 3) || NumberParsing.isDuplication(numbers)) {
            throw new IllegalArgumentException();
        }

        return numbers;

    }


    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

}
