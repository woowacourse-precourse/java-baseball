package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        sendMassage(GameMassage.START_MASSAGE);

        GameStatus restartOrEnd = GameStatus.START;
        while (restartOrEnd != GameStatus.END) {
            List<Integer> computer = randomThreeDigit();
            boolean answer = false;
            while (!answer) {
                sendMassage(GameMassage.INPUT_NUMBER);
                List<Integer> user = getUserInput();
                answer = calculationDigits(computer, user);
            }

            restartOrEnd = getRestartOrEndGame();
        }
    }

    private static GameStatus getRestartOrEndGame() {
        sendMassage(GameMassage.ANSWER);
        sendMassage(GameMassage.RESTART_OR_END);
        if (isRestart(Console.readLine())) {
            return GameStatus.START;
        }
        return GameStatus.END;
    }

    private static void sendMassage(GameMassage massage) {
        System.out.print(massage.getMassage());
    }

    private static boolean calculationDigits(List<Integer> computer, List<Integer> user) {
        StrikeAndBall strikeAndBall = new StrikeAndBall();
        strikeAndBall.compareDigits(computer, user);
        GameMassage gameMassage = strikeAndBall.getResult();

        sendMassage(gameMassage);

        return gameMassage == GameMassage.ALL_STRIKE;
    }

    private static boolean isRestart(String str) {
        String regex = "[1]{1,1}";
        if (str.length() == 1) {
            return str.matches(regex);
        }
        return false;
    }

    private static void checkDuplicatedDigits(List<Integer> values, boolean[] visited, int digit) {
        if (!visited[digit]) {
            values.add(digit);
            visited[digit] = true;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> inputToDigits(String input) throws IllegalArgumentException {
        boolean[] visited = new boolean[10];
        List<Integer> values = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int digit = input.charAt(i) - '0';
            checkDuplicatedDigits(values, visited, digit);
        }
        return values;
    }

    private static List<Integer> getUserInput() throws IllegalArgumentException {
        String input = Console.readLine();
        String isDigitRegex = "[1-9]{3,3}";

        if (input.matches(isDigitRegex)) {
            return inputToDigits(input);
        }
        throw new IllegalArgumentException();
    }

    private static void addNumber(List<Integer> digits, int number) {
        if (!digits.contains(number)) {
            digits.add(number);
        }
    }

    private static List<Integer> randomThreeDigit() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < Digits.RANGE.getDigit()) {
            int randomNumber = Randoms.pickNumberInRange(Digits.FIRST.getDigit(),
                    Digits.LAST.getDigit());
            addNumber(digits, randomNumber);
        }
        return digits;
    }
}
