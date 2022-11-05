package baseball.service;

import baseball.domain.Referee;

import java.util.List;

public class BaseballService {

    private final Referee referee;

    public BaseballService() {
        this.referee = new Referee();
    }

    public void init() {
        referee.makeRandomValues();
    }

    public String checkCounts(List<Integer> numbers) {
        return referee.checkCounts(numbers);
    }

    public boolean isGameOver() {
        return referee.isAllStrike();
    }
}
