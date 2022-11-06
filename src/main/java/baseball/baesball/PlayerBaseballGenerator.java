package baseball.baesball;

import baseball.console.ConsoleInput;

import java.util.List;

public class PlayerBaseballGenerator implements BaseballGenerator {
    private final ConsoleInput consoleInput;

    public PlayerBaseballGenerator(ConsoleInput consoleInput) {
        this.consoleInput = consoleInput;
    }

    @Override
    public Baseball generateBaseball() {
        String baseball = consoleInput.readBaseBall();
        List<Integer> parsedBaseball = parseFrom(baseball);
        return new Baseball(parsedBaseball);
    }
}
