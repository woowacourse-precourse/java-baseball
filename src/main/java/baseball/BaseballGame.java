package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static baseball.Validate.*;

public class BaseballGame extends NumberGame {
    @Override
    public void start() {

    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    public boolean end() {
        return false;
    }

    public Point hint(String playerInput) {
        int strike;
        int ball;
        int temp;

        List<String> numberList = Arrays.asList(playerInput.split(""));
        List<String> randomNumberList = Arrays.asList(computer.split(""));

        temp = (int) randomNumberList.stream().filter(e -> numberList.stream().anyMatch(Predicate.isEqual(e))).count();
        strike = (int) IntStream.range(0, 3).filter(e -> numberList.get(e).equals(randomNumberList.get(e))).count();
        ball = temp - strike;
        Point point = new Point();
        point.setBall(ball).setStrike(strike);
        return point;
    }
}
