package baseball.board;

import baseball.compare.ComparisonResult;
import baseball.compare.ComparisonResultType;
import baseball.compare.Referee;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

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

    public String getResultMessage() {
        HashMap<ComparisonResultType, Integer> resultFrequency = comparisonResult.getFrequency();
        List<String> messageList = new ArrayList<>();

        if (resultFrequency.size() != 0) {
            Optional<String> ballResultMessage = makeResultMessage(resultFrequency, ComparisonResultType.BALL);
            ballResultMessage.ifPresent(messageList::add);

            Optional<String> strikeResultMessage = makeResultMessage(resultFrequency, ComparisonResultType.STRIKE);
            strikeResultMessage.ifPresent(messageList::add);

            return String.join(" ", messageList);
        }

        return NumberBoardConstant.NOT_MATCH_AT_ALL_MESSAGE;
    }

    private Optional<String> makeResultMessage(HashMap<ComparisonResultType, Integer> resultFrequency,
            ComparisonResultType type) {
        if (resultFrequency.containsKey(type)) {
            return Optional.of(resultFrequency.get(type) + type.getValue());
        }
        return Optional.empty();
    }
}
