package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputTranslator {

    Validator validator = new Validator();

    public Balls translateInput(String playerInput) {
        List<Ball> playerBalls = new ArrayList<>();

        String[] input = playerInput.split("");
        validator.validateType(input);

        for (int i = 0; i < input.length; i++) {
            Ball ball = new Ball(Integer.parseInt(input[i]));
            playerBalls.add(ball);
        }

        validator.validateLength(playerBalls);
        validator.validateDuplicate(playerBalls);

        return new Balls(playerBalls);
    }
}
