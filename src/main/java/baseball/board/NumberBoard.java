package baseball.board;

import baseball.compare.ComparisonResult;
import baseball.compare.ComparisonResultType;
import baseball.compare.Referee;
import java.util.List;

public class NumberBoard {

    private final ComparisonResult comparisonResult = new ComparisonResult();
    ;

    public boolean compare(List<Integer> userNumbers, List<Integer> opponentNumbers) {
        for (int i = 0; i < userNumbers.size(); i++) {
            Integer userNumber = userNumbers.get(i);
            Integer opponentNumber = opponentNumbers.get(i);

            compareNumber(userNumber, opponentNumber);
        }

        return comparisonResult.getFrequency().get(ComparisonResultType.STRIKE).equals(opponentNumbers.size());
    }

    private void compareNumber(Integer userNumber, Integer opponentNumber) {
        this.comparisonResult.add(Referee.judge(userNumber, opponentNumber));
    }

}
