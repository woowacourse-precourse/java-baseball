package baseball;

import constant.Messages;
import domain.Numbers;

public class Result {
    private int strikeCount;
    private int ballCount;

    public Result(Numbers computerNumber, Numbers userNumber) {
        strikeCount = computerNumber.countStrike(userNumber);
        ballCount = computerNumber.countBall(userNumber);
    }

    public String getResult() {
        if(this.strikeCount == 3) return Messages.successMessage;
        if(this.strikeCount == 0 && this.ballCount == 0) return Messages.nothing;

        return this.ballCount + Messages.ball + " " + this.strikeCount + Messages.strike;
    }
}
