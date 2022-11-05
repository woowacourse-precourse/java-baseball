package baseball;

import camp.nextstep.edu.missionutils.Console;
import domain.Number;

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

    public int judgeStrike(Number number, List<Integer> computerNumber,  int strike) {   // 스트라이크 판정
        for (int digit = 0; digit < 3; digit++) {
            if (computerNumber.get(digit).equals(number.getDigit(digit))) {
                strike++;
            }
        }
        return strike;
    }
}
