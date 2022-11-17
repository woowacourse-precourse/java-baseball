package baseball.game.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static baseball.game.config.constants.GameRule.*;

public class NumberFactory {

    public static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < GAME_NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE_INTEGER, END_INCLUSIVE_INTEGER);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }

        return numbers;
    }
}
