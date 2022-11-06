package baseball;

import baseball.model.BaseBallHitsType;

import java.util.*;

public class BaseBallGame {

    public Map<BaseBallHitsType, Integer> baseBallHitsTypeMap(List<Character> tempHomeRun, List<Character> parameters) {
        BallNumbers homeRun = new BallNumbers(tempHomeRun);
        BallNumbers hits = new BallNumbers(parameters);

        return BaseBallHitsType.hitsTypeMap(homeRun,hits);
    }

}
