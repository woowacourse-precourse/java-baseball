package baseball.opponent;

import baseball.domain.Hint;
import baseball.domain.ThreeDigitNum;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerOpponent implements Opponent {


    private ThreeDigitNum answer;

    public ComputerOpponent() {
        answer = createAnswer();
    }


    @Override
    public int getType() {
        return Opponent.COMPUTER_OPPONENT;
    }

    @Override
    public ThreeDigitNum createAnswer() {
        return createRandomThreeDigitNum();
    }

    private ThreeDigitNum createRandomThreeDigitNum() {
        return new ThreeDigitNum(Randoms.pickUniqueNumbersInRange(ThreeDigitNum.START_RANGE, ThreeDigitNum.END_RANGE,
                ThreeDigitNum.SIZE));
    }

    @Override
    public Hint makeHint(ThreeDigitNum inputValue) {
        return new Hint(this.answer, inputValue);
    }

}
