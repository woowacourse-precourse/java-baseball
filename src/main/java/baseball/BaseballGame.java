package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    public List<Integer> input() {   // 입력
        System.out.print(INPUT_NUMBER);
        String inputNumber = Console.readLine();

        return stringToIntegerList(inputNumber);
    }

    public List<Integer> stringToIntegerList(String inputNumber) {  // 입력 값을 List<Integer>로
        List<Integer> number = new ArrayList<>();

        for (int digit = 0; digit < inputNumber.length(); digit++) {
            number.add(Integer.parseInt(String.valueOf(inputNumber.charAt(digit))));
        }
        return number;
    }
}
