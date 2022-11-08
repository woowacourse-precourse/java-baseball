package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Computer {
    public static Balls generateBalls() {
        return asBalls(getUniqueNumbers());
    }

    private static Balls asBalls(Collection<Integer> uniqueNumbers) {
        List<Ball> balls = new ArrayList<>();
        int position = 0;

        for (Integer number : uniqueNumbers) {
            balls.add(new Ball(number, position));
            position++;
        }

        return new Balls(balls);
    }

    private static Set<Integer> getUniqueNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (hasEnough(uniqueNumbers)) {
            int randomNumber = Randoms.pickNumberInRange(Ball.NUMBER_LOWER_BOUNDS, Ball.NUMBER_UPPER_BOUNDS);
            uniqueNumbers.add(randomNumber);
        }

        return uniqueNumbers;
    }

    private static boolean hasEnough(Set<Integer> uniqueNumbers) {
        return uniqueNumbers.size() != Balls.NUMBER_OF_BALLS;
    }
}
