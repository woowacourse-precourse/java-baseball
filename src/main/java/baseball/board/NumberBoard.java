package baseball.board;

import baseball.compare.ComparisonResult;
import baseball.compare.ComparisonResultType;
import baseball.compare.Referee;
import java.util.HashMap;
import java.util.List;

public class NumberBoard {

    private final ComparisonResult comparisonResult = new ComparisonResult();

    public HashMap<ComparisonResultType, Integer> compareNumbers(List<Integer> userNumbers,
            List<Integer> opponentNumbers) {
        for (int i = 0; i < userNumbers.size(); i++) {
            Integer userNumber = userNumbers.get(i);
            Referee.judge(userNumber, i, opponentNumbers).ifPresent(this.comparisonResult::add);
        }

        return comparisonResult.getFrequency();
    }
}
