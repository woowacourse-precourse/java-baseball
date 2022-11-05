package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallMaker {
    private int ballSize;
    private boolean allowDuplicate;

    private int minimum;
    private int maximum;


    public BallMaker() {
        this.ballSize = 3;
        this.allowDuplicate = false;
        this.maximum=9;
        this.minimum=1;
    }

    public List<Integer> getRandomBall() {
        if (!allowDuplicate) {
            return getUniqueRandomBall();
        }
        return new ArrayList<>();
    }

    private List<Integer> getUniqueRandomBall() {
        Set<Integer> result = new HashSet<>();
        while (result.size() != ballSize) {
            result.add(Randoms.pickNumberInRange(minimum,maximum));
        }
        return new ArrayList<>(result);
    }

    public List<Integer> getUserBall() {
        List<Integer> userBall = new ArrayList<>();
        return userBall;
    }
}
