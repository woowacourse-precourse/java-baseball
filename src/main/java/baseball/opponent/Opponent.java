package baseball.opponent;

import baseball.domain.Hint;
import baseball.domain.ThreeDigitNum;

public interface Opponent {

    public static final int COMPUTER_OPPONENT = 1;

    public int getType();
    ThreeDigitNum createAnswer();
    public Hint makeHint(ThreeDigitNum inputValue);

    public static Opponent makeOpponent(int type) {
        switch (type) {
            case COMPUTER_OPPONENT:
                return new ComputerOpponent();
            default:
                return null;
        }
    }
}
