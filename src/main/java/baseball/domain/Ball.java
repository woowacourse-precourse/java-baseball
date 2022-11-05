package baseball.domain;

public class Ball {

    private BallNumber number;
    public Ball(int number) {
        this.number = new BallNumber(number);
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
