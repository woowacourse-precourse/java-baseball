package baseball.input;

import baseball.game.Number;

public class GameInput {

    public Number number;

    public GameInput(int num) {
        isInputValidRange(num);

        number = new Number(num);
        areInputDigitsUnique(number);
    }

    private void isInputValidRange(int num) {
        if (100 <= num && num < 1000) {
            return;
        }
        throw new IllegalArgumentException("3자리 수를 입력해주세요.");
    }

    private void areInputDigitsUnique(Number num) {
        if (num.first == num.second || num.second == num.third || num.first == num.third) {
            throw new IllegalArgumentException("서로 다른 3자리 수를 입력해주세요.");
        }
    }

    @Override
    public String toString() {
        return "No:" + number;
    }
}
