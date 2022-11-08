package baseball.model;

import static baseball.controller.InputValidator.INPUT_LENGTH;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumGenerator {

    public static List<Integer> generate() {
        Set<Integer> randomThreeNumber = new HashSet<>();
        while (randomThreeNumber.size() < INPUT_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomThreeNumber.contains(randomNumber)) {
                randomThreeNumber.add(randomNumber);
            }
        }
        return new ArrayList<>(randomThreeNumber);
    }
}
