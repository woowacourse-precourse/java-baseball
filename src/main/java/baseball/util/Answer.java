package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/08
 */
public class Answer {
    // TODO: 랜덤 숫자(정답) 생성
    public static List<Integer> create() {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < Constant.LENGTH_OF_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(Constant.ANSWER_MIN_DIGIT, Constant.ANSWER_MAX_DIGIT);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }
}
