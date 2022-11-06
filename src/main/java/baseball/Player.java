package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
    private static final String INT_REGEX = "^[0-9]*$";
    private static final Player PLAYER = new Player();

    public static Player getPlayer() {
        return PLAYER;
    }

    private List<Integer> stringToList(String userInput) {
        int[] input = Stream.of(userInput.split("")).mapToInt(Integer::parseInt).toArray();
        return Arrays.stream(input)
                .boxed()
                .collect(Collectors.toList());
    }

    public void checkNumber(String userInput) throws IllegalArgumentException {
        if(!userInput.matches(INT_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

}