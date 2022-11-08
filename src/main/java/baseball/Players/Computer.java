package baseball.Players;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int GAME_NUMBERS_SIZE = 3;

    public List<Integer> getNumberList() {
        List<Integer> computerNumbers = new ArrayList<>();
        while (computerNumbers.size() < GAME_NUMBERS_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}
