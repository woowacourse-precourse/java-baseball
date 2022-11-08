package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    public static List<Integer> makeAnswer() {
        List<Integer> answer = new ArrayList<>();

        // 중복되지 않도록 세 숫자 고르기
        while (answer.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(random))
                answer.add(random);
        }
        // System.out.println(answer);
        return answer;
    }
}
