package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class BaseBallGameUtil {
    // TODO: 랜덤 숫자(정답) 생성
    public static List<Integer> createAnswerByLength(int length) {
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < length) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    // TODO: 데이터 입력받아, 랜덤 숫자와 같은 형태로 형태변환
    public static List<Integer> inputUserAnswer() {
        return toIntegerList(Console.readLine());
    }

    private static List<Integer> toIntegerList(String input) {
        List<Integer> userAnswer = new ArrayList<>();
        for (String digit : input.split("")) {
            userAnswer.add(Integer.parseInt(digit));
        }
        return userAnswer;
    }
}
