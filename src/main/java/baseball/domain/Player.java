package baseball.domain;

import java.util.List;

public class Player {

    private Computer computer;

    private Hint hint;

    public Player(Computer computer) {
        this.computer = computer;
    }

    public String checkCounts(List<Integer> numbers) {
        this.hint = computer.checkCounts(numbers);
        return hint.toString();
    }

    public boolean isAllStrike() {
        return hint.isAllStrike();
    }
}
