package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Computer {
    public List<Integer> numbers = new ArrayList<>();

    public void setRandomNumber(int range_start, int range_end, int BASEBALL_GAME_NUMBER_LENGTH){
        this.numbers.clear();
        while (numbers.size() < BASEBALL_GAME_NUMBER_LENGTH) {
            int randomNumber = pickNumberInRange(range_start, range_end);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }
}
