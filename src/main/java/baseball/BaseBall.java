package baseball;

import baseball.io.Output;
import baseball.model.Numbers;

public class BaseBall {
    private static final int NUMBER_MIN_VALUE = 1;
    private static final int NUMBER_MAX_VALUE = 9;
    private static final int COUNT_OF_NUMBERS = 3;

    private NumberGenerator numberGenerator;
    private Output output;

    public BaseBall(NumberGenerator numberGenerator, Output output) {
        this.numberGenerator = numberGenerator;
        this.output = output;
    }

    public void play(){
        Numbers computerNumbers = numberGenerator.generateUniqueNumbersInRange(NUMBER_MIN_VALUE, NUMBER_MAX_VALUE, COUNT_OF_NUMBERS);

    }
}
