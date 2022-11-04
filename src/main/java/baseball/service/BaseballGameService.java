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

    private List<Integer> getUserNumbers() {
        GameGuidePrinter.requestNumberMessage();

        String input = Console.readLine();
        checkUserInput(input);

        String[] numbers = input.split("");
        return Arrays.stream(numbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    private void checkUserInput(String input) throws IllegalArgumentException {
        checkInputSize(input);

        String[] numbers = input.split("");

        for (String number: numbers) {
            if (!checkNumberRange(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void checkInputSize(String input) throws IllegalArgumentException {
        if (input.length() != size) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkNumberRange(String number) throws IllegalArgumentException {
        return '0' <= number.charAt(0) && number.charAt(0) <= '9';
    }

}
