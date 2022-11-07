package baseball.controller;

import baseball.domain.computer.Computer;
import baseball.domain.referee.Referee;
import baseball.utils.message.OutputMessage;
import baseball.view.input.Input;
import baseball.view.output.Output;
import java.util.List;

public class GameController {

    private final Input input;
    private final Output output;
    private final Computer computer;
    private final Referee referee;

    public GameController(Input input, Output output, Computer computer, Referee referee) {
        this.input = input;
        this.output = output;
        this.computer = computer;
        this.referee = referee;
    }

    public void runBaseballGame() {
        output.printlnMessage(OutputMessage.START);
        GameContext gameContext = new GameContext(true);
        while (gameContext.isGameContext()) {
            List<Integer> randomNumber = computer.generateRandomNumber();
            runEachSet(randomNumber);

            output.printlnMessage(OutputMessage.END);
            gameContext.updateContext(input.endInput());
        }
    }

    private void runEachSet(List<Integer> randomNumber) {
        while (true) {
            output.printMessage(OutputMessage.NUMBER_REQUEST);
            String userInput = input.baseballInput();

            String baseballResult = computer.checkBallAndStrike(randomNumber, userInput);
            output.printlnMessage(baseballResult);

            if (referee.isEndGameSet(baseballResult)) {
                output.printlnMessage(OutputMessage.SUCCESS);
                break;
            }
        }
    }

}
