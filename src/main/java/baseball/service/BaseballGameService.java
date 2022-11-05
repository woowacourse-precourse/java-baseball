package baseball.service;

import baseball.domain.Computer;
import baseball.domain.User;
import baseball.printer.GameGuidePrinter;
import baseball.util.RandomNumber;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class BaseballGameService {

    private User user;
    private Computer computer;
    private int size;


    public void initGame(int start, int end, int size) {
        computer = new Computer(RandomNumber.getRandomNumbers(start, end, size));
        this.size = size;

        GameGuidePrinter.startGameMessage();
    }
    private void calculateUserScore(List<Integer> userNumbers, List<Integer> gameNumbers) {
        for (int i = 0; i < size; i++) {
            calculate(userNumbers, gameNumbers.get(i), i);
        }
    }

    private void calculate(List<Integer> userNumbers, int gameNumber, int gameIndex) {
        int userIndex = -1;
        for (int i = 0; i < size; i++) {
            if (userNumbers.get(i).equals(gameNumber)) {
                userIndex = i;
                break;
            }
        }
        increaseGameCount(userIndex, gameIndex);
    }

    private void increaseGameCount(int userIndex, int gameIndex) {
        if (userIndex == gameIndex) {
            computer.increaseStrikeCount();
        }
        if (userIndex != gameIndex) {
            computer.increaseBallCount();
        }
    }

    private List<Integer> getUserNumbers() {
        GameGuidePrinter.requestNumberMessage();

        String input = Console.readLine();
        String[] numbers = input.split("");

        checkUserInput(numbers);
        return parseIntegerList(numbers);
    }

    private List<Integer> parseIntegerList(String[] numbers) {
        return Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private void checkUserInput(String[] numbers) throws IllegalArgumentException {
        checkInputSize(numbers);

        for (String number: numbers) {
            if (!checkNumberRange(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkInputSize(String[] input) throws IllegalArgumentException {
        if (input.length != size) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNumberRange(String number) {
        return '0' <= number.charAt(0) && number.charAt(0) <= '9';
    }

}
