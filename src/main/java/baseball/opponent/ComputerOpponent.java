package baseball.opponent;

import baseball.domain.Hint;
import baseball.domain.ThreeDigitNum;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> threeDigitList = new ArrayList<>();
        while (threeDigitList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!threeDigitList.contains(randomNumber)) {
                threeDigitList.add(randomNumber);
            }
        }
        return new ThreeDigitNum(threeDigitList);
        /*
        셔플 방식으로 짠 코드입니다.
        랜덤 생성이 작위적인 이유로, 오류가 나 주석처리하였습니다.
        List<Integer> integerList = new ArrayList<>();
        for (int num = ThreeDigitNum.START_RANGE; num <= ThreeDigitNum.END_RANGE; ++num) {
            integerList.add(num);
        }

        for (int currIdx = 0; currIdx < integerList.size()-1; currIdx++) {

            int changeIdx = Randoms.pickNumberInRange(currIdx,  integerList.size()-1);
            int temp = integerList.get(changeIdx);
            integerList.set(changeIdx, integerList.get(currIdx));
            integerList.set(currIdx, temp);

        }

        List<Integer> suffled = integerList.subList(0, ThreeDigitNum.SIZE);

        return new ThreeDigitNum(suffled);
        */
    }

    @Override
    public Hint makeHint(ThreeDigitNum inputValue) {
        return new Hint(this.answer, inputValue);
    }

}
