package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

public class BallNumber {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;

    private int value;

    private BallNumber(int value) {
        this.value = value;
    }

    public static BallNumber from(int value) {
        validate(value);

        return new BallNumber(value);
    }

    private static void validate(int value) {
        if (value < MIN_NUMBER || value > MAX_NUMBER) {
            throw new IllegalArgumentException("공 위치는 1~9 사이 값만 생성 가능합니다.");
        }
    }

    public static int createRandomBallNumberValue() {
        return Randoms.pickNumberInRange(
                BallNumber.MIN_NUMBER,
                BallNumber.MAX_NUMBER
        );
    }

    public int value() {
        return value;
    }
}
