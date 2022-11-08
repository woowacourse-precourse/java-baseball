package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;

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
    public static boolean validateGameInput(String input) {
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
    public static List<Integer> convertInputToList(String input) {
        return Arrays.stream(input.split(""))
                .map(s->Integer.valueOf(s))
                .collect(Collectors.toList());
    }
    public static boolean checkBallStrike(List<Integer> gameAnswer, List<Integer> input) {
        int strike = 0;
        int ball = 0;

        int index = -1;
        for (Integer answer: gameAnswer) {
            int tempIndex = input.indexOf(answer);

            index++;
            if (tempIndex < 0)
                continue;

            if (tempIndex == index)
                strike++;
            else
                ball++;
        }

        printBallStrike(strike, ball);

        return strike == 3;
    }
    public static void printBallStrike(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return ;
        }

        if (ball > 0)
            System.out.print(new StringBuilder().append(ball).append("볼"));

        if (ball > 0 && strike > 0)
            System.out.print(" ");

        if (strike > 0)
            System.out.print(new StringBuilder().append(strike).append("스트라이크"));

        System.out.println();

        if (strike == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return ;
        }
    }
    public static void playGame(List<Integer> gameAnswer) {
        boolean result = false;
        while (!result) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();

            if (!validateGameInput(input))
                throwIllegalArgumentException();

            List<Integer> userAnswer = convertInputToList(input);
            result = checkBallStrike(gameAnswer, userAnswer);
        }
    }
    public static boolean checkRestart(String input) {
        if (input.equals("1"))
            return true;
        else if (input.equals("2"))
            return false;
        throwIllegalArgumentException();
        return false;
    }
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        String restartInput;
        do {
            List<Integer> answer = generateGameAnswer();
            playGame(answer);

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            restartInput = Console.readLine();

        } while (checkRestart(restartInput));
    }
}
