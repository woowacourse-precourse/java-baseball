package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;

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
        String[] numbers = input.split("");
        Set<String> keys = new HashSet<>();
        for (String number : numbers) {
            if (keys.contains(number))
                return true;
            keys.add(number);
        }
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
    public static List<Integer> getUserAnswer() {
        List<Integer> userAnswer = new ArrayList<>();
        String input = Console.readLine();
        if (!validInput(input))
            throwIllegalArgumentException();
        for (int index = 0; index < input.length(); index++) {
            int temp = input.charAt(index) - '0';
            userAnswer.add(temp);
        }
        return userAnswer;
    }
    public static boolean checkBallStrike(List<Integer> gameAnswer, List<Integer> input) {
        int strike = 0;
        int ball = 0;

        for (int count = 0; count < input.size(); count++) {
            int ch = input.get(count);
            if (gameAnswer.get(count) == ch)
                strike++;
            else if (gameAnswer.contains(ch))
                ball++;
        }
        return printBallStrike(strike, ball);
    }
    public static boolean printBallStrike(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return false;
        }
        if (ball != 0) {
            System.out.print(ball);
            System.out.print("볼");
            if (strike != 0)
                System.out.print(" ");
            else if (strike == 0)
                System.out.println("");
        }
        if (strike != 0) {
            System.out.print(strike);
            System.out.println("스트라이크 ");
        }
        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }
    public static void playGame(List<Integer> gameAnswer) {
        boolean result = false;
        while (!result) {
            System.out.print("숫자를 입력해주세요 : ");
            result = checkBallStrike(gameAnswer, getUserAnswer());
        }
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
            playGame(initGame());
            newGame = checkRestart();
        }
    }
}
