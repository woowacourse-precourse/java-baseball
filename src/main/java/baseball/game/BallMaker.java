package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BallMaker {
    private int minimum;
    private int maximum;
    private NumberMaker numberMaker;


    public BallMaker() {
        this.maximum = 9;
        this.minimum = 1;
        this.numberMaker = new RandomNumberMaker(minimum, maximum);
    }

    public BallMaker(int minNum) {
        this.maximum = 9;
        this.minimum = minNum;
        this.numberMaker = new RandomNumberMaker(minimum, maximum);
    }

    public Ball makeBall(List<Integer> ballData) {
        return new Ball(ballData);
    }

    public Ball getUniqueRandomBall(int ballSize) {
        List<Integer> result = new ArrayList<>();
        while (result.size() != ballSize) {
            int randomNumber = numberMaker.generate();
            if (!result.contains(randomNumber)) {
                result.add(randomNumber);
            }
        }
        return makeBall(result);
    }
}
