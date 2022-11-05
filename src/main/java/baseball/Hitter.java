package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hitter {

    public List<Ball> hitBalls(String number) {
        return IntStream.range(0, number.length())
                .mapToObj(index ->
                        new Ball(Character.getNumericValue(number.charAt(index)), index))
                .collect(Collectors.toList());
    }
}
