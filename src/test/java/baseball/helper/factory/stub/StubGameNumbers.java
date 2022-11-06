package baseball.helper.factory.stub;

import baseball.domain.number.GameNumbers;

public class StubGameNumbers extends GameNumbers {

    private final long returnStrike;
    private final long returnBall;

    public StubGameNumbers(long returnStrike, long returnBall) {
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
