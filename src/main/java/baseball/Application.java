package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println(createAnswer());
    }

    // 정답을 생성하는 함수: 정답은 1~9까지 서로 다른 수로 이루어진 3자리의 수이다.
    public static List<Integer> createAnswer() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        return answer;
    }
}
