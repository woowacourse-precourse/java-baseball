package baseball.service;

import baseball.domain.Player;
import baseball.domain.Referee;

import java.util.List;

public class BaseballService {

    private final Referee referee;
    private final Player player;

    public BaseballService() {
        this.referee = new Referee();
        this.player = new Player(referee);
    }

    public void init() {
        referee.makeRandomValues();
    }

    public String checkCounts(List<Integer> numbers) {
        return player.checkCounts(numbers);
    }

    public boolean isGameOver() {
        return player.isAllStrike();
    }
}
