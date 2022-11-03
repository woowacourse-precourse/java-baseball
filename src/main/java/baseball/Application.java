package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.startGame();

        String input;
        boolean match;

        do {
            System.out.print("숫자를 입력해주세요 : ");
            input = Console.readLine();
            isValidNumber(input);

            match = computer.getResult(Integer.parseInt(input));
            if (match) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                input = Console.readLine();

            }

        } while (!match);
    }

    public static void isValidNumber(String input) {
        if (!isThreeNumber(input) || !isDifferentNumber(input)) {
            throw new IllegalArgumentException("서로 다른 3자리의 수를 입력해야 합니다.");
        }
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
