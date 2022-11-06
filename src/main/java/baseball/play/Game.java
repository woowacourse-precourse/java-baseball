package baseball.play;

import baseball.input.ComputerInput;
import baseball.input.UserInput;
import baseball.output.Guide;
import baseball.validatioon.Validation;
import java.util.*;

public class Game {
    ComputerInput computerInput = new ComputerInput();
    UserInput input = new UserInput();

    public void start() {
        boolean isRestart = false;
        Round round = new Round();

        do {
            List<Integer> computerNumberList = computerInput.getNumberList();
            round.run(computerNumberList);
            Guide.printRestartGuide();
            int restartOption = input.getRestartOption();
            isRestart = Validation.isRestart(restartOption);
        } while (isRestart);
    }
}
