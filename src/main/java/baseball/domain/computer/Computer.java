package baseball.domain.computer;

import baseball.domain.number.BaseBallGameNumbers;

public class Computer {

    private final BaseBallGameNumbers numbers;

    public Computer(BaseBallGameNumbers baseBallGameNumbers) {
        this.numbers = baseBallGameNumbers;
    }

    public BaseBallGameNumbers baseBallGameNumbers() {
        return this.numbers;
    }
}
