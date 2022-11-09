package baseball.play;

import baseball.input.ComputerInput;
import baseball.input.UserInput;
import baseball.output.Guide;
import baseball.validatioon.Validation;
import java.util.*;

public class Game {
    ComputerInput computerInput = new ComputerInput();
    UserInput userInput = new UserInput();

    public void start() {
        boolean isRestart;
        Round round = new Round();

        do {
            List<Integer> computerNumberList = computerInput.getNumberList();
            round.run(computerNumberList);
            Guide.printRestartGuide();
            int restartOption = userInput.getRestartOption();
            isRestart = Validation.isRestart(restartOption);
        } while (isRestart);
    }
}
