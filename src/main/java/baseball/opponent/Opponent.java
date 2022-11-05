package baseball.opponent;

import baseball.domain.Hint;
import baseball.domain.ThreeDigitNum;

public interface Opponent {

    ThreeDigitNum createAnswer();
    public Hint getHint(ThreeDigitNum inputValue);
}
