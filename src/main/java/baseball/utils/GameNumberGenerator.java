package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static baseball.resources.GameConfig.*;

public class GameNumberGenerator {
    public static ArrayList<Integer> generate(){
        Set<Integer> gameNumber = new HashSet<>();
        while (gameNumber.size() < SIZE) {
            gameNumber.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
        }
        return new ArrayList<>(gameNumber);
    }
}
