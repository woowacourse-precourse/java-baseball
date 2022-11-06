package baseball;

import java.util.List;

public interface HintCalculator {

    Hint getHint(List<Integer> computer, List<Integer> user);
}
