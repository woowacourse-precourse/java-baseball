package baseball;

public class ScoreConfirmation {

    private static final int NUMBER_COUNT_NOTHING = 0;

    public static void confirm(NumberCheck numberCheck) {
        confirmBallStrikeNothingCase(numberCheck);
        confirmBallCase(numberCheck);
        confirmStrikeCase(numberCheck);
        confirmBallStrikeCase(numberCheck);
    }

    private static void confirmBallStrikeNothingCase(NumberCheck numberCheck) {
        if (numberCheck.getBall() == NUMBER_COUNT_NOTHING && numberCheck.getStrike() == NUMBER_COUNT_NOTHING) {
            Output.printNothingMessage();
        }
    }

    private static void confirmBallCase(NumberCheck numberCheck) {
        if (numberCheck.getBall() > NUMBER_COUNT_NOTHING && numberCheck.getStrike() == NUMBER_COUNT_NOTHING) {
            Output.printBallMessage(numberCheck.getBall());
        }
    }

    private static void confirmStrikeCase(NumberCheck numberCheck) {
        if (numberCheck.getBall() == NUMBER_COUNT_NOTHING && numberCheck.getStrike() > NUMBER_COUNT_NOTHING) {
            Output.printStrikeMessage(numberCheck.getStrike());
        }
    }

    private static void confirmBallStrikeCase(NumberCheck numberCheck) {
        if (numberCheck.getBall() > NUMBER_COUNT_NOTHING && numberCheck.getStrike() > NUMBER_COUNT_NOTHING) {
            Output.printBallStrikeMessage(numberCheck.getBall(), numberCheck.getStrike());
        }
    }

}
