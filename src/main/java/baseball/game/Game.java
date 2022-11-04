package baseball.game;

import baseball.computer.Computer;
import baseball.counter.Counter;
import baseball.io.InputUtils;
import baseball.io.OutputUtils;
import baseball.io.UserInput;

public class Game {

    private final Result result;
    private final Computer computer;
    private final Counter counter;
    private UserInput userInput;

    public Game(Result result, Computer computer, Counter counter) {
        this.result = result;
        this.computer = computer;
        this.counter = counter;
    }

    private GameResult getGameResult() {
        int strikeCount = counter.getStrikeCount();
        int ballCount = counter.getBallCount();

        return result.getGameResult(strikeCount, ballCount);
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
