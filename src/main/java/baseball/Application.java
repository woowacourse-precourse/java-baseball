package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Set<Integer> gameNumber = new HashSet<>();
        while (gameNumber.size() < 3) {
            gameNumber.add(Randoms.pickNumberInRange(1, 9));
        }
    }
}
