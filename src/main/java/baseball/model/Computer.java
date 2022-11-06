package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    public static Balls generateBalls() {
        List<Integer> computerNum = new ArrayList<>();
        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }

        List<Ball> balls = new ArrayList<>();
        for (int position = 0; position < Balls.NUMBER_OF_BALLS; position++) {
            Integer number = computerNum.get(position);
            balls.add(new Ball(number, position));
        }
        return new Balls(balls);
    }
}
