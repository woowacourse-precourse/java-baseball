package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }

    public static Integer[] generateAnswer() {
        List<Integer> answerList = new ArrayList<>();
        while (answerList.size() < 3) {
            int generated = Randoms.pickNumberInRange(1, 9);
            if (answerList.contains(generated)) {
                continue;
            }
            answerList.add(generated);
        }
        return answerList.toArray(Integer[]::new);
    }


}
