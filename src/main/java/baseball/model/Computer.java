package baseball.model;

import baseball.tools.GenerateNumber;

public class Computer {
    private final String RandomBaseballNumber = String.valueOf(new GenerateNumber().pickThreeUniqueRandomNumber());

    public String getRandomBaseballNumber() {
        return RandomBaseballNumber;
    }
}
