package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    static List<Integer> pickRandomNumber() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(number)) {
                answer.add(number);
            }
        }
        return answer;
    }
}