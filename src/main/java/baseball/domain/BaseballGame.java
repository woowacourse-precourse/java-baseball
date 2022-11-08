package baseball.domain;

public class BaseballGame {

    private static final int RESTART = 1;
    private static final int END = 2;
    private static final int RESULT_END = 3;
    private static final String RESTART_NUMBER_EXCEPTION = "재시작/종료를 구분하는 " + RESTART + "과 " + END + " 중 하나의 수 입니다.";
    private final Numbers numbers;

    public BaseballGame(Numbers numbers) {
        this.numbers = numbers;
    }

    public Hints result(Numbers numbers) {
        return this.numbers.compare(numbers);
    }

    public boolean isNotEnd(Hints hints) {
        return hints.count(Hint.STRIKE) != RESULT_END;
    }

    public boolean isRestart(int number) {
        validateRestartNumberBound(number);
        return number == RESTART;
    }

    private static void validateRestartNumberBound(int number) {
        if (number < RESTART || number > END) {
            throw new IllegalArgumentException(RESTART_NUMBER_EXCEPTION);
        }
    }
}
