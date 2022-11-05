package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Game {
    private int getRandomIntegerExcludeInList(List<Integer> answer) {
        int number;
        do {
            number = Randoms.pickNumberInRange(1, 9);
        } while (answer.contains(number));
        return number;
    }
}
