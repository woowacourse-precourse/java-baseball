package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Game.NUMBER_OF_DIGIT;

public class NumComputerPicker {

    public static List<Integer> pickNumComputer() {
        List<Integer> numComputer = new ArrayList<>();
        while (numComputer.size() < NUMBER_OF_DIGIT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numComputer.contains(randomNumber)) {
                numComputer.add(randomNumber);
            }
        }

        return numComputer;
    }
}
