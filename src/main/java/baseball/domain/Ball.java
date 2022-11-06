package baseball.domain;

public class Ball {
    private final int maximumNumber = 9;
    private final int minimumNumber = 1;
    private int number;
    public Ball(int number) {
        if (number>maximumNumber && number<minimumNumber) {
            throw new IllegalArgumentException("1에서 9의 값을 입력해주세요");
        }
        this.number = number;
    }

    public Judgement judge(Ball otherBall) {
        if (this.equals(otherBall)) {
            return Judgement.SAME_VALUE;
        }
        return Judgement.NOTHING;
    }
    @Override
    public boolean equals(Object o){
        if (o==null) return false;
        if (getClass() != o.getClass()) return false;
        Ball otherBall = (Ball) o;
        if (number.equals(otherBall.number)) {
            return true;
        }
        return false;
    }
}
