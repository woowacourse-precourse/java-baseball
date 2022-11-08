package baseball.utility;

public class ResultEvaluator {

    private ResultEvaluator() {

    }

    private static int isStrikeOrNot(String computerNumber, String playerNumber, int index) {
        if (computerNumber.charAt(index) == playerNumber.charAt(index)) {
            return 1;
        }
        return 0;
    }
}
