package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final int FINISH = 2;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Computer computer = new Computer();
        System.out.println("숫자 야구 게임을 시작합니다.");
        computer.startGame();

        boolean match = false;
        boolean done = false;

        do {
            if (match) {
                computer.startGame();
            }

            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            isValidNumber(input);

            match = computer.getResult(Integer.parseInt(input));
            if (match) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String command = Console.readLine();
                isValidCommand(command);

                done = checkIfDone(command);
            }

        } while (!match || (match && !done));
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

    public static void isValidCommand(String input) {
        if (!isOneOrTwo(input)) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

    public static boolean isOneOrTwo(String input) {
        String pattern = "[1|2]";
        if (input.matches(pattern)) {
            return true;
        }
        return false;
    }

    public static boolean checkIfDone(String command) {
        if (Integer.parseInt(command) == FINISH) {
            return true;
        }
        return false;
    }
}
