package baseball.baesball;

import baseball.console.ConsoleInput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static baseball.util.CharacterUtil.NO_SPACE;

public class PlayerBaseballGenerator implements BaseballGenerator {
    private final ConsoleInput consoleInput = new ConsoleInput();

    @Override
    public Baseball generateBaseball() {
        String baseball = consoleInput.readBaseBall();
        List<Integer> parsedBaseball = parseFrom(baseball);
        return new Baseball(parsedBaseball);
    }

    private List<Integer> parseFrom(String baseball) {
        String[] baseballs = baseball.split(NO_SPACE.getUnit());
        return Arrays.stream(baseballs)
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }
}
