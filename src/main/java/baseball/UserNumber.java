package baseball;

import java.util.ArrayList;
import java.util.List;

public class UserNumber {

    private final static int MAX_SIZE = 3;

    private List<Integer> number = new ArrayList<>();

    public UserNumber(String inputNumber) {
        this.number = converter(inputNumber);
    }

    public List<Integer> getNumber() {
        return number;
    }

    private static List<Integer> converter(String inputNumber) {
        List<Character> numbers = charConverter(inputNumber);

        isNumber(numbers);
        isMaxSize(numbers);
        isContainsZero(numbers);
        isDuplicationNumber(numbers);

        return intConverter(numbers);
    }

    private static List<Character> charConverter(String inputNumber) {
        List<Character> result = new ArrayList<>();
        for (int index = 0; index < inputNumber.length(); index++) {
            result.add(inputNumber.charAt(index));
        }
        return result;
    }

    private static List<Integer> intConverter(List<Character> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Character number : numbers) {
            result.add(number - '0');
        }
        return result;
    }

    //== 예외 처리 로직 ==//
    private static void isNumber(List<Character> numbers) {
        for (Character number : numbers) {
            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isMaxSize(List<Character> numbers) {
        if (numbers.size() != MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void isContainsZero(List<Character> numbers) {
        for (Character number : numbers) {
            if (number == '0') {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isDuplicationNumber(List<Character> numbers) {
        List<Character> contain = new ArrayList<>();
        for (Character number : numbers) {
            if (contain.contains(number)) {
                throw new IllegalArgumentException();
            }
            contain.add(number);
        }
    }
}
