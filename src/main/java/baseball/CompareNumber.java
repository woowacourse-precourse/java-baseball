package baseball;

import java.util.List;

public class CompareNumber {
    public static Ball compare(List<Integer> computer, List<Integer> input) {
        Ball ball = new Ball();

        for (int num : input) {
            if (computer.get(input.indexOf(num)) == num)
                ball.increaseStrike();
            else if (computer.contains(num))
                ball.increaseBall();
        }

        return ball;
    }
}
