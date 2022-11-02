package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Start {
    public static List<Integer> startGame() {
        List<Integer> correctAnswer = new ArrayList<>(3);

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (correctAnswer.size() < 3) {
            int baseNumber = Randoms.pickNumberInRange(1, 9);
            if (!correctAnswer.contains(baseNumber)) {
                correctAnswer.add(baseNumber);
            }
        }
        return correctAnswer;
    }
}
