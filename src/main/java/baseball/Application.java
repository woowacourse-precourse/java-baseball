package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();

        while (true) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            String input = Console.readLine();
            if (isValidNumber(input)) {
                computer.startGame();
            } else {
                throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해야 합니다.");
            }
        }
    }

    public static boolean isValidNumber(String input) {
        if (isThreeNumber(input) && isDifferentNumber(input)) {
            return true;
        }
        return false;
    }

    public static boolean isThreeNumber(String input) {
        String pattern = "[1-9]{3}";
        if (input.matches(pattern)) {
            return true;
        }
        return false;
    }

    public static boolean isDifferentNumber(String input) {
        List<Character> numberList = new ArrayList<>();
        for (char number : input.toCharArray()) {
            if (numberList.contains(number)) {
                return false;
            }
            numberList.add(number);
        }
        return true;
    }
}
