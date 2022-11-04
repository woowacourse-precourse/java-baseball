package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGame {
    Computer computer = new Computer();

    public int run() {
        computer.pickTargetNumber();
        Computer.GameResult result;
        do {
            System.out.print("숫자를 입력해주세요. : ");
            List<Integer> userNumber = checkUserNumber(Console.readLine());
            result = computer.compare(userNumber);
            printResult(result);
        } while (nextTurn(result));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return checkUserAnswer(Console.readLine());
    }

    public void printResult(Computer.GameResult result) {
        System.out.println(result);
    }

    public List<Integer> checkUserNumber(String userInput) throws IllegalArgumentException {
        if (illegalInput(userInput)) {
            throw new IllegalArgumentException();
        }
        return toIntList(userInput);
    }

    private boolean illegalInput(String userInput) {
        if (userInput.length() != 3) {
            return true;
        }
        Set<Integer> duplicateCheckSet = new HashSet<>();
        for (int i = 0; i < userInput.length(); i++) {
            char c = userInput.charAt(i);
            if (!Character.isDigit(c) || Character.getNumericValue(c) == 0) {
                return true;
            }
            int number = Character.getNumericValue(c);
            if (duplicateCheckSet.contains(number)) {
                return true;
            }
            duplicateCheckSet.add(number);
        }
        return false;
    }

    private List<Integer> toIntList(String userInput) {
        List<Integer> user = new ArrayList<>();
        for (int i = 0; i < userInput.length(); i++) {
            user.add(Character.getNumericValue(userInput.charAt(i)));
        }
        return user;
    }

    public boolean nextTurn(Computer.GameResult result) {
        if (result.strike == 3) {
            return false;
        }
        return true;
    }

    public int checkUserAnswer(String userInput) throws IllegalArgumentException {
        if (userInput.length() != 1) {
            throw new IllegalArgumentException();
        }
        char c = userInput.charAt(0);
        if (!Character.isDigit(c)) {
            throw new IllegalArgumentException();
        }
        int number = Character.getNumericValue(c);
        if (number == 1 || number == 2) {
            return number;
        }
        throw new IllegalArgumentException();
    }
}
