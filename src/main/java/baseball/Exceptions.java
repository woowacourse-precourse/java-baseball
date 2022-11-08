package baseball;

import java.util.List;
import java.util.stream.Collectors;

import static baseball.Constant.*;

public class Exceptions {

    public static void isValidInputUserNums(String userNumberInString) {
        isValidLength(userNumberInString);
        isNumeral(userNumberInString);
        isUniqueNumbers(userNumberInString);
    }

    private static void isValidLength(String userNumberInString) {
        if (userNumberInString.length() != RANGE) {
            throw new IllegalArgumentException("입력하신 값의 길이가 3이 아닙니다.");
        }
    }

    private static void isNumeral(String userNumberInString) {
        try {
            Integer.parseInt(userNumberInString);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다. 프로그램을 종료합니다.");
        }
    }

    private static void isUniqueNumbers(String userNumberInString) {
        List<Integer> userNums = UserNumber.convertUserNumbers(userNumberInString);
        List<Integer> uniqueNumbers = userNums.stream()
                .distinct()
                .collect(Collectors.toList());

        if (uniqueNumbers.size() != RANGE) {
            throw new IllegalArgumentException("중복된 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
    }

    public static void isValidReGameAnswer(String reGameAnswer) {
        try {
            Integer.parseInt(reGameAnswer);
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 재게임 입력입니다. 프로그램을 종료합니다.");
        }
        int reGameAnswerNum = Integer.parseInt(reGameAnswer);
        if (reGameAnswerNum != START_GAME && reGameAnswerNum != END_GAME) {
            throw new IllegalArgumentException("올바르지 않은 재게임 입력입니다. 프로그램을 종료합니다.");
        }
    }
}
