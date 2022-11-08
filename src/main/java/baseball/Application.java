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
    }
}