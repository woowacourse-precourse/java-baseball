package baseball.model;

import baseball.utils.Utils;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerNumber {

    private final List<Integer> playerNums;

    public PlayerNumber(String input) {
        playerNums = parseInput(input);
    }

    private List<Integer> parseInput(String input) {
        input = Utils.deleteAllSpace(input);
        return Arrays.stream(input.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> get() {
        return playerNums;
    }
}
