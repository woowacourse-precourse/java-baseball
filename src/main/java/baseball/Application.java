package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");


    }

    private static List<String> receivingValue() {
        String inputValue = Console.readLine();
        List<String> numbers = List.of(inputValue);

        handlingException(numbers);

        return numbers;
    }

    private static void handlingException(List<String> numbers) {
        try {
            checkValue(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println("e = " + e);
        }
    }

    private static void checkValue(List<String> numbers) throws IllegalArgumentException {
        if (numbers.contains("0") || numbers.size() > 3) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isIncludingZero(List<String> numbers) {
        return numbers.contains("0");
    }

    private static boolean isSizeOverThree(List<String> numbers) {
        return numbers.size() > 3;
    }

}
