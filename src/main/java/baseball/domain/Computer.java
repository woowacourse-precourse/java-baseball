package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    List<Integer> numbers = new ArrayList<>();

    public void setRandomNumber(){
        this.numbers.clear();
        while (numbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
