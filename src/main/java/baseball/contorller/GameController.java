package baseball.contorller;

import baseball.domain.Ball;
import baseball.domain.Config;
import baseball.service.GameService;
import baseball.view.Views;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private static final int NUMBER_TYPE = 9;

    private final GameService service;

    public GameController(GameService service) {
        this.service = service;
    }

    public void start() {
        service.startGame();
        Views.INITIAL_VIEW.getView().view();

        checkHint();
    }

    public void checkHint() {
        Views.INPUT_VIEW.getView().view();
        String input = Console.readLine();
        validateInput(input);

        List<Ball> balls = Arrays.stream(input.split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(Ball::fromNumber)
                .collect(Collectors.toList());
    }

    private void validateInput(String input) {
        if (!isNumber(input) || isOutOfBounds(input)) throw new IllegalArgumentException();
    }

    private boolean isNumber(String string) {
        return string.chars()
                .allMatch(c -> Character.getType(c) == NUMBER_TYPE);
    }

    private boolean isOutOfBounds(String string) {
        return string.length() != Config.MAX_BALLS_SIZE;
    }
    }
}
