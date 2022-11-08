package baseball.domain;

import java.util.List;

import static baseball.constant.Constant.*;

public class Rule {
    public void applyHint(List<Integer> numbers, List<Integer> computerNumbers) {
        Hint.init();
        for(int i=0; i<numbers.size(); i++) {
            if(numbers.get(i) == computerNumbers.get(i)) {
                Hint.addCount(Hint.STRIKE);
            }
            else if(computerNumbers.contains(numbers.get(i))) {
                Hint.addCount(Hint.BALL);
            }
        }
    }

    public boolean isReset(String number) {
        return number.equals(RESET_GAME);
    }
}
