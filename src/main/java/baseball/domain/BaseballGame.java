package baseball.domain;

public class BaseballGame {

    private static final int RESTART = 1;
    private static final int END = 2;
    private final Numbers numbers;

    public BaseballGame(Numbers numbers) {
        this.numbers = numbers;
    }

    public Hints result(Numbers numbers) {
        return this.numbers.match(numbers);
    }

    public boolean isEnd(Hints hints) {
        return hints.count(Hint.STRIKE) == 3;
    }

    public boolean restart(int number) {
        validateRestartNumberBound(number);
        return number == RESTART;
    }

    private static void validateRestartNumberBound(int number) {
        if (number < RESTART || number > END) {
            throw new IllegalArgumentException("재시작/종료를 구분하는 " + RESTART + "과 " + END + " 중 하나의 수 입니다.");
        }
    }
}
