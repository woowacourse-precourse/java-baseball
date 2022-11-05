package baseball;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class ComputerOpponent implements Opponent {


    static final int START_RANGE = 1;
    static final int END_RANGE = 9;
    static final int SIZE = 3;

    private List<Integer> answer = null;

    public ComputerOpponent() {
        answer = createAnswer();
        validateValue();
    }


    @Override
    public List<Integer> createAnswer() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }
    private void validateValue() {
        List<Integer> freq = new ArrayList<>(Collections.nCopies(END_RANGE + 1, 0));

        for (int valueEach : answer) {
            if (valueEach < START_RANGE | valueEach > END_RANGE) {
                throw new IllegalArgumentException("야구게임 값의 각 자릿수는 1 ~ 9사이여야 합니다.");
            }
            if (freq.get(valueEach) != 0) {
                throw new IllegalArgumentException("야구 게임의 값의 각 자릿수는 서로 달라야 합니다.");
            }

            freq.set(valueEach, 1);
        }
    }

    @Override
    public Hint getHint(List<Integer> inputValue) {
        return new Hint(this.answer, inputValue);
    }

}
