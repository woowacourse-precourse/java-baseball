package baseball.baseballgame;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class NumberToListChanger {

    public static final String SEPARATOR = "";

    public static List<Integer> change(String userInputNumbers) {
        return Arrays.stream(userInputNumbers.split(SEPARATOR))
                .map(Integer::valueOf)
                .collect(toList());
    }
}
