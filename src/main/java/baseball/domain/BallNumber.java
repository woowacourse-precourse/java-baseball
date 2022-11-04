package baseball.domain;

public class BallNumber {
    private final int maximumNumber = 9;
    private final int minimumNumber = 1;
    private int number;
    public BallNumber(int number) {
        if (number>maximumNumber && number<minimumNumber) {
            throw new IllegalArgumentException("1에서 9의 값을 입력해주세요");
        }
        this.number = number;
    }
    @Override
    public boolean equals(Object o) {
        if (o==null) return false;
        if (getClass() != o.getClass()) return false;
        BallNumber otherNumber = (BallNumber) o;
        if (number == otherNumber.number) {
            return true;
        }
        return false;
    }
}
