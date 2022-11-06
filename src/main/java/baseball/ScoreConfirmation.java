package baseball;

public class ScoreConfirmation {

    private static final int NUMBER_COUNT_NOTHING = 0;

    public void confirm(int ball, int strike) {
        confirmBallStrikeNothingCase(ball, strike);
        confirmBallCase(ball, strike);
        confirmStrikeCase(ball, strike);
        confirmBallStrikeCase(ball, strike);
    }

    private void confirmBallStrikeNothingCase(int ball, int strike) {
        if (ball == NUMBER_COUNT_NOTHING && strike == NUMBER_COUNT_NOTHING) {
            Output.printNothingMessage();
        }
    }

    private void confirmBallCase(int ball, int strike) {
        if (ball > NUMBER_COUNT_NOTHING && strike == NUMBER_COUNT_NOTHING) {
            Output.printBallMessage(ball);
        }
    }

    private void confirmStrikeCase(int ball, int strike) {
        if (ball == NUMBER_COUNT_NOTHING && strike > NUMBER_COUNT_NOTHING) {
            Output.printStrikeMessage(strike);
        }
    }

    private void confirmBallStrikeCase(int ball, int strike) {
        if (ball > NUMBER_COUNT_NOTHING && strike > NUMBER_COUNT_NOTHING) {
            Output.printBallStrikeMessage(ball, strike);
        }
    }

}
