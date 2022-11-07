package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Answer {

    public static List<Integer> createAnswer() {

        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randNumber)) {
                answer.add(randNumber);
            }
        }
        return answer;
    }

    public static boolean checkAnswer(List<Integer> answer) {   // Index ( 0 : BALL / 1 : STRIKE )
        if (answer.get(1) == 3) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else {
            return false;
        }
    }
}
