package baseball.domain;

import baseball.util.GameValidation;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class BaseBall implements Game {

    private final List<Integer> computerNumbers;

    public BaseBall() {
        computerNumbers = Randoms.pickUniqueNumbersInRange((int) GameValidation.START_RANGE,
            (int) GameValidation.END_RANGE, GameValidation.GAME_NUMBER_LENGTH);
    }

    @Override
    public void play() {

    }
}
