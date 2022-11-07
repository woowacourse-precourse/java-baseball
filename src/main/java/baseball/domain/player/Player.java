package baseball.domain.player;

import baseball.domain.number.BaseBallGameNumbers;

public class Player {

    private BaseBallGameNumbers numbers;

    public void changeNumbers(BaseBallGameNumbers baseBallGameNumbers) {
        this.numbers = baseBallGameNumbers;
    }

    public BaseBallGameNumbers baseBallGameNumbers() {
        return this.numbers;
    }
}
