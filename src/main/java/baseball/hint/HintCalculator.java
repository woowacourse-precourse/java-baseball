package baseball.hint;

import java.util.List;

public interface HintCalculator {

    Hint getHint(List<Integer> computer, List<Integer> user);
}
