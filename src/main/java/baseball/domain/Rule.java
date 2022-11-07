package baseball.domain;

import java.util.List;

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
}
