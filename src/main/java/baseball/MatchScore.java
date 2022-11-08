package baseball;

public class MatchScore {

    private static final int NUMBER_COUNT_NOTHING = 0;

    public static void compareMatchScore(NumberCheck numberCheck) {
        compareBallStrikeNothingCase(numberCheck);
        compareBallCase(numberCheck);
        compareStrikeCase(numberCheck);
        compareBallStrikeCase(numberCheck);
    }

    private static void compareBallStrikeNothingCase(NumberCheck numberCheck) {
        if (numberCheck.getBall() == NUMBER_COUNT_NOTHING && numberCheck.getStrike() == NUMBER_COUNT_NOTHING) {
            Output.printNothingMessage();
        }
    }

    private static void compareBallCase(NumberCheck numberCheck) {
        if (numberCheck.getBall() > NUMBER_COUNT_NOTHING && numberCheck.getStrike() == NUMBER_COUNT_NOTHING) {
            Output.printBallMessage(numberCheck.getBall());
        }
    }

    private static void compareStrikeCase(NumberCheck numberCheck) {
        if (numberCheck.getBall() == NUMBER_COUNT_NOTHING && numberCheck.getStrike() > NUMBER_COUNT_NOTHING) {
            Output.printStrikeMessage(numberCheck.getStrike());
        }
    }

    private static void compareBallStrikeCase(NumberCheck numberCheck) {
        if (numberCheck.getBall() > NUMBER_COUNT_NOTHING && numberCheck.getStrike() > NUMBER_COUNT_NOTHING) {
            Output.printBallStrikeMessage(numberCheck.getBall(), numberCheck.getStrike());
        }
    }

}
