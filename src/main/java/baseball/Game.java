package baseball;

import baseball.computer.Computer;
import baseball.counter.Counter;
import baseball.io.InputUtils;
import baseball.io.OutputUtils;
import baseball.io.UserInput;

public class Game {

    private final Computer computer;
    private final Counter counter;
    private UserInput userInput;

    public Game(Computer computer, Counter counter) {
        this.computer = computer;
        this.counter = counter;
    }

    private void play() {
        String input = InputUtils.readNumbersWrittenByUser();
        InputUtils.checkIsValidInput(input);

        userInput = new UserInput(input);
        counter.count(userInput.getUserInputNumbers(), computer.getComputerHoldNumbers());
    }

    public void start() {
        OutputUtils.printGameStartMessage();
        computer.generateRandomNumber();
    }
}
