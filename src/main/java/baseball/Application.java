package baseball;

import baseball.process.Comparison;
import baseball.process.Process;

public class Application {
    static final int NUMBER_OF_DIGIT = 3;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        new Process(NUMBER_OF_DIGIT).initialize();
    }
}
