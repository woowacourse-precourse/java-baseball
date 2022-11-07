package baseball.domain;

import baseball.constant.Constant;

import java.util.List;

import static baseball.constant.Constant.*;

public class Rule {
    public void getHint(List<Integer> numbers, List<Integer> computerNumbers) {
        for(int i=0; i<numbers.size(); i++) {
            int number = computerNumbers.indexOf(numbers.get(i));
            if(i == number) {
                Hint.addCount(Hint.STRIKE);
            }
            else if(number != -1) {
                Hint.addCount(Hint.BALL);
            }
        }

        System.out.println(Hint.getHintByCount());
    }

    public boolean isReset(String number) {
        return number.equals(RESET_GAME);
    }
}
