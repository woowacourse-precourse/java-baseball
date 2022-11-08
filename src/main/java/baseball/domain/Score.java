package baseball.domain;

import baseball.view.OutputView;

import java.util.List;
import java.util.stream.IntStream;

public class Score {
    private int strikeCount;
    private int ballCount;
    public void countBallAndStrike(BaseballNumbers userInput, BaseballNumbers correctNumber) {
        strikeCount =0;
        ballCount = 0;
        strikeCount = compareStrike(userInput,correctNumber);
        ballCount = compareBall(userInput, correctNumber);

    }
    public int compareStrike(BaseballNumbers userInput, BaseballNumbers correctNumber) {
        List<BaseballNumber> otherBaseballNumbers = userInput.getBaseballNumberList();
        return (int) IntStream.range(0, 3)
                .filter(index -> correctNumber.getBaseballNumberList().get(index).equals(otherBaseballNumbers.get(index)))
                .count();
    }

    public int compareBall(BaseballNumbers userInput, BaseballNumbers correctNumber) {
        List<BaseballNumber> otherBaseballNumbers = userInput.getBaseballNumberList();
        int ballNumber = 0;
        for (int otherBaseballIndex = 0; otherBaseballIndex < 3; otherBaseballIndex++) {
            if (hasBall(otherBaseballIndex, otherBaseballNumbers, correctNumber)) {
                ballNumber++;
            }
        }

        return ballNumber;
    }

    private boolean hasBall(int otherBaseballIndex, List<BaseballNumber> otherBaseballNumbers, BaseballNumbers correctNumber) {
        for (int thisBaseballIndex = 0; thisBaseballIndex < 3; thisBaseballIndex++) {
            if (thisBaseballIndex == otherBaseballIndex) {
                continue;
            }

            if (correctNumber.getBaseballNumberList().get(otherBaseballIndex).equals(otherBaseballNumbers.get(thisBaseballIndex))) {
                return true;
            }
        }

        return false;
    }

    public boolean isEqualTo(BaseballNumbers userInput, BaseballNumbers correctNumbers) {
        List<BaseballNumber> otherBaseballNumbers = userInput.getBaseballNumberList();
        return IntStream.range(0, 3)
                .allMatch(index -> correctNumbers.getBaseballNumberList().get(index).equals(otherBaseballNumbers.get(index)));
    }
    public void print(){
        OutputView.printScore(strikeCount, ballCount);
    }
}
