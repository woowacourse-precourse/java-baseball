package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static List<Integer> createAnswer() {
        List<Integer> answerNumbers = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int number = Randoms.pickNumberInRange(0, 9);
            if (!answerNumbers.contains(number)) {
                answerNumbers.add(number);
            }
        }
        return answerNumbers;

    }
}
