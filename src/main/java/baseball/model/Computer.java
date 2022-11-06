package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Computer {
    public static Balls generateBalls() {
        List<Integer> uniqueNumbers = getUniqueNumbers();

        return asBalls(uniqueNumbers);
    }

    private static Balls asBalls(List<Integer> uniqueNumbers) {
        List<Ball> balls = new ArrayList<>();
        int position = 0;

        for (Integer number : uniqueNumbers) {
            balls.add(new Ball(number, position));
            position++;
        }

        return new Balls(balls);
    }

    private static List<Integer> getUniqueNumbers() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < Balls.NUMBER_OF_BALLS) {
            int randomNumber = Randoms.pickNumberInRange(Ball.NUMBER_LOWER_BOUNDS, Ball.NUMBER_UPPER_BOUNDS);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
        return computerNum;
    }
}
