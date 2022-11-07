package baseball.service;

import baseball.domain.BaseballNumber;
import baseball.view.BaseballGameInputView;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballGameService {
    private final BaseballNumber computer;

    public BaseballGameService() {
        computer = new BaseballNumber();
    }

    public List<Integer> getCounts() {
        BaseballNumber player = BaseballGameInputView.getPlayerNumber();
        int strike = 0;
        int ball = 0;
        Set<Integer> computerSet = new HashSet<>(computer.getBaseballNumber());

        for (int idx = 0; idx < 3; idx++) {
            if (player.getBaseballNumber().get(idx) == computer.getBaseballNumber().get(idx)) {
                strike++;
            } else if (computerSet.contains(player.getBaseballNumber().get(idx))) {
                ball++;
            }
        }

        return List.of(ball, strike);
    }
}
