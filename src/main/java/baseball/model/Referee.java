package baseball.model;

import java.util.List;

public class Referee {

    private List<Integer> computerSelectNumbers;
    private boolean allStrike = false;
    public Referee(List<Integer> computerSelectNumbers) {
        this.computerSelectNumbers = computerSelectNumbers;
    }

    public boolean isAllStrike() {
        return allStrike;
    }
    public boolean checkAllStrike() {
        return true;
    }
}
