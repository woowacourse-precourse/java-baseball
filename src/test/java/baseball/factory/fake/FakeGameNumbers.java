package baseball.factory.fake;

import baseball.domain.number.GameNumbers;

public class FakeGameNumbers extends GameNumbers {

    private final long returnStrike;
    private final long returnBall;

    public FakeGameNumbers(long returnStrike, long returnBall) {
        this.returnStrike = returnStrike;
        this.returnBall = returnBall;
    }

    @Override
    public long calculateStrike(GameNumbers playerAnswer) {
        return this.returnStrike;
    }

    @Override
    public long calculateBall(GameNumbers playerAnswer) {
        return this.returnBall;
    }
}
