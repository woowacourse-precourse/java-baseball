package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {

    public static List<Integer> generate() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < Balls.BALLS_SIZE) {
            addNumber(computer);
        }
        return computer;
    }

    private static void addNumber(List<Integer> computer) {
        int randomNumber = Randoms.pickNumberInRange(Ball.MIN_NUMBER, Ball.MAX_NUMBER);
        if (!computer.contains(randomNumber)) {
            computer.add(randomNumber);
        }
    }
}
