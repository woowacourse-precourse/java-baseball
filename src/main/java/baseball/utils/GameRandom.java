package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class GameRandom {
    private GameRandom() {
    }

    private static class LazyHolder {
        private static final GameRandom INSTANCE = new GameRandom();
    }

    public static GameRandom getInstance() {
        return LazyHolder.INSTANCE;
    }

    public List<Integer> makeNumbers() {
        List<Integer> numberList = new ArrayList<>();
        while (numberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numberList.contains(randomNumber))
                numberList.add(randomNumber);
        }
        return numberList;
    }
}
