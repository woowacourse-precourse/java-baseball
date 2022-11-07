package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class PlayGame {
    public static List<Integer> getRandomNumbers(){
        List<Integer> gameNumbers = new ArrayList<>();

        while (gameNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!gameNumbers.contains(randomNumber)) {
                gameNumbers.add(randomNumber);
            }
        }

        return gameNumbers;
    }
}
