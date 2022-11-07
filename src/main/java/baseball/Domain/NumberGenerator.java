package baseball.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    public static final int GAME_NUM_LENGTH = 3;
    public static List<Integer> make3RandomNum(){
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < GAME_NUM_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

}
