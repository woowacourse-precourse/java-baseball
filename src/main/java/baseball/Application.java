package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    private static List<Integer> inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputData = Console.readLine();
        validateNumber(inputData);

        List<Integer> inputNumber = new ArrayList<>();
        for (char digit : inputData.toCharArray()) {
            inputNumber.add(digit - 48);
        }

        return inputNumber;
    }

    private static void validateNumber(String inputData) {
        try {
            Integer.parseInt(inputData);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("the input only allows integer");
        }

        if (inputData.length() != 3) {
            throw new IllegalArgumentException("the input only allows three-digit numbers");
        }

        for (char digit : inputData.toCharArray()) {
            if (digit == '0') {
                throw new IllegalArgumentException("each digit only allows 1~9");
            }
        }
    }
}
