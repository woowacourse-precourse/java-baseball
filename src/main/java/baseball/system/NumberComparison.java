package baseball.system;

import java.util.List;

public class NumberComparison {

    private final int NUMBERS_SIZE = 3;

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

    private int getStrikeCount() {

        int strikeCount = 0;

        for(int indexNumber = 0; indexNumber < NUMBERS_SIZE; indexNumber++){
            if(userNumbers.get(indexNumber) == computerNumbers.get(indexNumber) ){
                strikeCount++;
            }
        }

        return strikeCount;
    }

    private void setUserNumbers(List<Integer> userNumbers) {
        this.userNumbers = userNumbers;
    }


}
