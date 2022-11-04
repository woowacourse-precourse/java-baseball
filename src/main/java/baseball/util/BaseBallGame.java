package baseball.util;

import java.util.List;

public class BaseBallGame {
    private final List<Integer> computerRandomThreeValue;


    public BaseBallGame(List<Integer> computerRandomThreeValue) {
        this.computerRandomThreeValue = List.copyOf(computerRandomThreeValue);
    }

}
