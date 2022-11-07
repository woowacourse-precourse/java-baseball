package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    public static List<Integer> getRandomValue() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            ifNotContain(answer, Randoms.pickNumberInRange(1, 9));
        }
        return answer;
    }

    public static void ifNotContain(List<Integer> answer, int number) {
        if (!answer.contains(number)) {
            answer.add(number);
        }
    }
}
