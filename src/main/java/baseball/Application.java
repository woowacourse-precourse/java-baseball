package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static baseball.Constant.*;

public class Application {
    public static void main(String[] args) {
        System.out.println(START_MESSAGE);
        do {
            playGame();
        } while (!isEnd());
    }

    public static void playGame() {
        List<Integer> targetNumber = createTargetNumber();

        boolean isGameOver = false;
        while (!isGameOver) {
            List<Integer> guessedNumber = readInput();

            int numberOfStrike = calculateStrike(targetNumber, guessedNumber);
            int numberOfBall = calculateBall(targetNumber, guessedNumber);

            printResult(numberOfStrike, numberOfBall);
            isGameOver = (numberOfStrike == DIGITS);
        }
        System.out.println(GAME_OVER_MESSAGE);
    }

    public static List<Integer> createTargetNumber() {
        ArrayList<Integer> targetNumber = new ArrayList<>();

        while (targetNumber.size() < DIGITS) {
            int digit = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT);

            if (!targetNumber.contains(digit)) {
                targetNumber.add(digit);
            }
        }
        return targetNumber;
    }

    public static List<Integer> readInput() {
        System.out.print(INPUT_MESSAGE);

        String input = Console.readLine();
        validateGuessedNumber(input);

        return parseGuessedNumber(input);
    }

    public static void validateGuessedNumber(String input) {
        if (!Pattern.matches(GUESSED_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException();
        }
        if (input.chars().distinct().count() != DIGITS) {
            throw new IllegalArgumentException();
        }
    }

    public static List<Integer> parseGuessedNumber(String input) {
        return input.chars().map(c -> c - '0').boxed().collect(Collectors.toList());
    }

    public static int calculateStrike(List<Integer> targetNumber, List<Integer> guessedNumber) {
        return (int) IntStream.range(0, DIGITS)
                .filter(index -> targetNumber.get(index).equals(guessedNumber.get(index)))
                .count();
    }

    public static int calculateBall(List<Integer> targetNumber, List<Integer> guessedNumber) {
        return (int) IntStream.range(0, DIGITS)
                .filter(index -> !targetNumber.get(index).equals(guessedNumber.get(index)))
                .filter(index -> targetNumber.contains(guessedNumber.get(index)))
                .count();
    }

    public static void printResult(int numberOfStrike, int numberOfBall) {
        if (numberOfStrike == 0 && numberOfBall == 0) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (numberOfStrike == 0) {
            System.out.println(numberOfBall + BALL_MESSAGE);
            return;
        }
        if (numberOfBall == 0) {
            System.out.println(numberOfStrike + STRIKE_MESSAGE);
            return;
        }
        System.out.println(numberOfBall + BALL_MESSAGE + " " + numberOfStrike + STRIKE_MESSAGE);
    }

    public static boolean isEnd() {
        System.out.println(RESTART_MESSAGE);

        String restartNumber = Console.readLine();
        validateRestartNumber(restartNumber);

        return restartNumber.equals(END);
    }

    public static void validateRestartNumber(String input) {
        if (!Pattern.matches(RESTART_NUMBER_REGEX, input)) {
            throw new IllegalArgumentException();
        }
    }
}