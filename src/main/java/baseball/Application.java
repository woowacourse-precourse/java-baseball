package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.ArrayList;

public class Application {
    public static List<Integer> generateGameAnswer() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    public static List<Integer> initGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        return generateGameAnswer();
    }
    public static void throwIllegalArgumentException() {
        throw new IllegalArgumentException("입력 값이 유효하지 않아 프로그램이 종료됩니다.");
    }
    public static boolean checkNonNumbers(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
    public static boolean checkRepeatNumber(String input) {
        if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2) || input.charAt(1) == input.charAt(2))
            return true;
        return false;
    }
    public static boolean validInput(String input) {
        if (input.length() != 3)
            return false;
        else if (input.contains("0"))
            return false;
        else if (checkNonNumbers(input))
            return false;
        else if (checkRepeatNumber(input))
            return false;
        return true;
    }
    public static boolean checkRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userAnswer = Console.readLine();
        if (userAnswer.equals("1")) {
            return true;
        } else if (userAnswer.equals("2"))
            return false;
        throwIllegalArgumentException();
        return false;
    }
    public static void main(String[] args) {
        boolean newGame = true;
        while (newGame) {
            newGame = checkRestart();
        }
    }
}
