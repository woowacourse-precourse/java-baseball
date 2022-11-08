package baseball.domain;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

public class Player {
    private Validator validator = new Validator();

    public String enterPlayerInput() {
        String playerInput = Console.readLine();
        validator.validatePlayerInputs(playerInput);
        return playerInput;
    }

    public String enterRestartInput() {
        String restartInput = Console.readLine();
        validator.validateRestartInput(restartInput);
        return restartInput;
    }
}
