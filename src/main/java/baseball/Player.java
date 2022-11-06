package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Player {
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

}