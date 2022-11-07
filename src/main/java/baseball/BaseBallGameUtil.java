package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

import static baseball.ArgumentExcpetion.isException;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/11/07
 */
public class BaseBallGameUtil {
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

    // 데이터 입력받아, Integer List로 반환
    public static List<Integer> inputUserAnsweByLength(int length) {
        String input = Console.readLine();
        isException(
                input.length() != length,
                ArgumentExceptionMessage.INPUT_UNCONFORMABLE_LENGTH); // 입력받은 값의 길이가 요구사항과 다른 경우
        return toIntegerList(input);
    }

    private static List<Integer> toIntegerList(String input) {
        List<Integer> userAnswer = new ArrayList<>();
        for (char tempInput : input.toCharArray()) {
            isException(
                    !Character.isDigit(tempInput),
                    ArgumentExceptionMessage.INPUT_NOT_INTEGER);  // 입력받은 값이 정수로 이루어져 있지 않은 경우
            int digit = Character.getNumericValue(tempInput);
            isException(
                    userAnswer.contains(digit),
                    ArgumentExceptionMessage.INPUT_OVERLAP);  // 입력받은 값에 중복되는 값이 존재하는 경우
            userAnswer.add(digit);
        }
        return userAnswer;
    }
}
