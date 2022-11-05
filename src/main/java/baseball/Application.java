package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");


    }

    private static boolean getResult() {
        List<String> receivingNumbers = receivingValue();
        List<String> random = createRandom();

        return false;
    }

    private static List<String> createRandom() {
        List<String> randomNumbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            randomNumbers.add(String.valueOf(randomNumber));
        }

        return randomNumbers;
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
        if (isIncludingZero(numbers) || isSizeOverThree(numbers)) {
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
