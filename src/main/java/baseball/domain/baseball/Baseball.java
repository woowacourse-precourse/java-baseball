package baseball.domain.baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Baseball {
    static final int MIN_BASEBALL_NUMBER = '1';
    static final int MAX_BASEBALL_NUMBER = '9';
    static final String OUT_OF_RANGE_MESSAGE = "입력이 1 ~ 9 까지 범위의 '숫자'가 아닙니다.";

    private final int number;

    private Baseball(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static Baseball of(int number) {
        if (!isValidRange(number)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_MESSAGE);
        }
        return new Baseball(number);
    }

    private static boolean isValidRange(int number) {
        return MIN_BASEBALL_NUMBER <= number && number <= MAX_BASEBALL_NUMBER;
    }

    public static Baseball random() {
        int randomNumber = createRandomNumber();
        return new Baseball(randomNumber);
    }

    private static int createRandomNumber() {
        return Randoms.pickNumberInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baseball baseball = (Baseball) o;
        return number == baseball.number;
    }

    @Override
    public int hashCode() {
        return number;
    }
}
