package baseball.validate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class UserValidator {

    /**
     * 야구게임 숫자를 맞출 때 입력한 값을 검증합니다.
     */
    public void validateNumber(String number) {
        if (Pattern.matches(".*\\s.*", number)) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }

        if (Pattern.matches(".*\\D.*", number)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (number.length() < 3) {
            throw new IllegalArgumentException("입력의 길이가 3보다 작습니다.");
        }

        if (number.length() > 3) {
            throw new IllegalArgumentException("입력의 길이가 3보다 큽니다.");
        }

        if (isDuplicateNumber(number)) {
            throw new IllegalArgumentException("서로 다른 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 재시작 질문에서 입력한 값을 검증합니다.
     */
    public void validateRestart(String number) {
        if (Pattern.matches(".*\\s.*", number)) {
            throw new IllegalArgumentException("공백은 입력할 수 없습니다.");
        }

        if (Pattern.matches(".*\\D.*", number)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }

        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException("1 또는 2로만 입력해야 합니다.");
        }
    }

    /**
     * 입력한 숫자에 중복이 있으면 true를 리턴하고, 그렇지 않으면 false를 리턴합니다.
     */
    private boolean isDuplicateNumber(String number) {
        if (getDistinctCount(number) == 3) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * 중복을 제거한 문자의 개수를 리턴합니다.
     */
    private int getDistinctCount(String number) {
        List<String> numberList = new ArrayList<>(Arrays.asList(number.split("")));

        return (int)numberList.stream()
                .distinct()
                .count();
    }

}
