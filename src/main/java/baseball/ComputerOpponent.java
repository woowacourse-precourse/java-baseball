package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class ComputerOpponent implements Opponent {


    private ThreeDigitNum answer = null;

    public ComputerOpponent() {
        answer = createAnswer();
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
    public Hint getHint(ThreeDigitNum inputValue) {
        return new Hint(this.answer, inputValue);
    }

}
