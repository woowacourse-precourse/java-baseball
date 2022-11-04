package baseball.domain;

import java.util.List;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException();
        }

    }

    public static Balls from(List<Integer> numbers) {
        return new Balls(numbers);
    }


}
