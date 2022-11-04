package baseball;

import java.util.List;

public class CompareNumber {
    public static Ball compare(List<Integer> computer, List<Integer> input) {
        Ball ball = new Ball();

        for (int i = 0; i < input.size(); i++) {
            if (isBall(computer, i, input.get(i))) {
                ball.increaseBall();
            }
            else if (isStrike(computer, i, input.get(i))) {
                ball.increaseStrike();
            }
        }

        return ball;
    }

    private static boolean isBall(List<Integer> computer, int i, int num) {
        return computer.contains(num) && computer.get(i) != num;
    }

    private static boolean isStrike(List<Integer> computer, int i, int num) {
        return computer.contains(num) && computer.get(i) == num;
    }
}
