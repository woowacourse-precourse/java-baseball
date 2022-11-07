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
    public static List<Integer> inputUserAnswer(int length) {
        String input = Console.readLine();
        if(input.length() != length) {
            throw new IllegalArgumentException();   // 입력받은 값의 길이가 요구사항과 다른 경우
        }
        return toIntegerList(input);
    }

    private static List<Integer> toIntegerList(String input) {
        List<Integer> userAnswer = new ArrayList<>();
        for (String digit : input.split("")) {
            if(userAnswer.contains(Integer.parseInt(digit))) {
                throw new IllegalArgumentException();   // 입력받은 값에 중복되는 값이 존재하는 경우
            }
            if ('1' <= digit.charAt(0) && digit.charAt(0) <= '9') {
                userAnswer.add(Integer.parseInt(digit));
            }
            else {
                throw new IllegalArgumentException();   // 입력받은 값이 숫자가 아닌 경우
            }
        }
        return userAnswer;
    }
}
