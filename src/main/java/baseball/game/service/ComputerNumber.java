package baseball.game.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {

    public static List<Integer> generate() {
        List<Integer> computerNumber = new ArrayList<>();

        while (computerNumber.size() < 3) {
            int key = Randoms.pickNumberInRange(1, 9);
            if (!computerNumber.contains(key)) {
                computerNumber.add(key);
            }
        }

        return computerNumber;
    }

}
;