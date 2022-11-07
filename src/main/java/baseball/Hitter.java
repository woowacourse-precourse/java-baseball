package baseball;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Hitter {

    public Balls hitBalls(String number) {
        return new Balls(IntStream.range(0, number.length())
                .mapToObj(index ->
                        new Ball(Character.getNumericValue(number.charAt(index)), index))
                .collect(Collectors.toList()));
    }
}
