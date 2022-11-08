package baseball.model;

import baseball.utils.NumberGenerator;

public class ComputerNumber {
    private final String BaseballNumber = String.valueOf(new NumberGenerator().setRandomNumber());

    public String getBaseballNumber() {
        return BaseballNumber;
    }
}
