package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static List<Integer> startGame() {
        List<Integer> correctAnswer = new ArrayList<>();

        while (correctAnswer.size() < 3) {
            int baseNumber = Randoms.pickNumberInRange(1, 9);
            if (!correctAnswer.contains(baseNumber)) {
                correctAnswer.add(baseNumber);
            }
        }
        return correctAnswer;
    }
}