package baseball;

import constant.Messages;
import domain.Numbers;

public class Compare {
    private int strikeCount;
    private int ballCount;

    public Compare(Numbers computerNumber, Numbers userNumber) {
        compareNumbers(computerNumber, userNumber);
    }

    public void compareNumbers(Numbers computerNumber, Numbers userNumber) {
        strikeCount = computerNumber.checkStrike(userNumber);
        ballCount = computerNumber.checkBall(userNumber);
    }

    public String getResult() {
        if(this.strikeCount == 3) return Messages.successMessage;
        if(this.strikeCount == 0 && this.ballCount == 0) return Messages.nothing;
        if(this.strikeCount == 0) return this.ballCount + Messages.ball;
        if(this.ballCount == 0) return this.strikeCount + Messages.strike;

        return this.ballCount + Messages.ball + " " + this.strikeCount + Messages.strike;
    }

    public boolean isThreeStrike() {
        if(this.strikeCount == 3) return true;
        return false;
    }
}
