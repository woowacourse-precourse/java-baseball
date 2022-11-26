package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Player {

    public List<Integer> selectNumbers(String readNumbers) {
        return Arrays.stream(readNumbers.split(""))
                .map((Integer::parseInt))
                .collect(Collectors.toList());
    }
}
