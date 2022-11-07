package baseball.service;

import static baseball.type.NumberType.NUMBER_SIZE;

import baseball.domain.Hint;
import baseball.view.OutputView;
import java.util.List;

public class HintService {
    public static Hint getHint(List<Integer> userNumbers, List<Integer> computerNumbers) {
        return new Hint(userNumbers, computerNumbers);
    }

    public static boolean isAnswer(Hint hint) {
        int strike = hint.getStrike();
        return strike == NUMBER_SIZE.getValue();
    }

    public static void printHint(Hint hint) {
        OutputView.printHint(hint);
    }
}
