package baseball.system;

import java.util.List;

public class NumberComparison {

    List<Integer> computerNumbers;
    List<Integer> userNumbers;

    public boolean startComparison(List<Integer> userNumbers) {

        setUserNumbers(userNumbers);

        int strikeCount = getStrikeCount();
        int ballCount = getBallCount();

        if (isAnswer(strikeCount)) {
            printAnswerText();
            return true;
        }

        if(isNothing(strikeCount,ballCount)){
            printNothingText();
            return false;
        }

        printStrikeBallCount(strikeCount,ballCount);
        return false;

    }

    private void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }


}
