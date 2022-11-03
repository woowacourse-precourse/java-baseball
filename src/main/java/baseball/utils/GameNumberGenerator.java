package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class GameNumberGenerator {
    public static Set<Integer> generate(){
        Set<Integer> gameNumber = new HashSet<>();
        while (gameNumber.size() < 3) {
            gameNumber.add(Randoms.pickNumberInRange(1, 9));
        }
        return gameNumber;
    }
}
