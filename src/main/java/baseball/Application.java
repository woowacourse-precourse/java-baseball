package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    private static final int NUMBER_DIGIT = 3;
    private static final int BALL_INDEX = 0;
    private static final int STRIKE_INDEX = 1;

    public static void main(String[] args) {
        printStartGameSentence();
        do {
            play();
        } while (retry());
    }

    private static void printStartGameSentence() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private static void play() {
        List<Integer> computerPick = getComputerPick();
        List<Integer> userPick;
        boolean success;
        do {
            userPick = getUserPick();
            success = isSuccess(userPick, computerPick);
        } while (!success);
    }

    private static boolean isSuccess(List<Integer> userPick, List<Integer> computerPick) {
        List<Integer> gameResults = getGameResults(userPick, computerPick);
        interpretGameResults(gameResults);
        if (gameResults.get(STRIKE_INDEX) == NUMBER_DIGIT) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        }
        return false;
    }

    private static List<Integer> getComputerPick() {
        List<Integer> numbers = new ArrayList<>();
        int number;
        while (numbers.size() < 3) {
            number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }

    private static List<Integer> getUserPick() {
        String input = inputNumber();
        return stringToIntegerList(input);
    }

    private static List<Integer> stringToIntegerList(String number) {
        return Arrays.stream(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateNumber(input);
        return input;
    }

    private static String inputRetry() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

    private static boolean retry() {
        String input = inputRetry();
        validateRetry(input);
        return input.equals("1");
    }

    private static void interpretGameResults(List<Integer> results) {
        int ball = results.get(BALL_INDEX);
        int strike = results.get(STRIKE_INDEX);

        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
            return;
        }

        List<String> response = new ArrayList<>();
        if (ball > 0) {
            response.add(ball + "볼");
        }
        if (strike > 0) {
            response.add(strike + "스트라이크");
        }
        System.out.println(String.join(" ", response));
    }

    private static void validateNumber(String input) {
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException();
        }

        Set<Character> history = new HashSet<>();
        char number;
        for (int i = 0; i < NUMBER_DIGIT; i++) {
            number = input.charAt(i);

            if (history.contains(number)) {
                throw new IllegalArgumentException();
            }
            history.add(number);
        }
    }

    private static void validateRetry(String input) {
        if (!input.matches("[1-2]")) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> getGameResults(List<Integer> prediction, List<Integer> answer) {
        List<Integer> results = Arrays.asList(0, 0);
        List<Boolean> strike = Arrays.asList(false, false, false);

        int predictionInt;
        int answerInt;
        for (int i = 0; i < NUMBER_DIGIT; i++) {
            predictionInt = prediction.get(i);
            answerInt = answer.get(i);
            if (predictionInt == answerInt) {
                results.set(STRIKE_INDEX, results.get(STRIKE_INDEX) + 1);
                strike.set(i, true);
            }
        }

        for (int i = 0; i < NUMBER_DIGIT; i++) {
            predictionInt = prediction.get(i);
            if (!strike.get(i) && answer.contains(predictionInt)) {
                results.set(BALL_INDEX, results.get(BALL_INDEX) + 1);
            }
        }
        return results;
    }
}
