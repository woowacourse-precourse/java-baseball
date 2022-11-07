package baseball;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class ValidationCode {
    public static void validateFlag(String flag) {
        isNotEndPoint(flag);
    }

    public static void validateAnswer(String answer) {
        isNotNumber(answer);
        isOutOfBounds(answer);
        isNotDistinct(answer);
    }

    private static void isNotEndPoint(String flag) {
        if(!flag.equals(EndPoint.End.getFlag()) && !flag.equals(EndPoint.RE_START.getFlag())){
            throw new IllegalArgumentException("1 or 2 만 입력할 수 있습니다.");
        }
    }

    public static void isNotNumber(String answer) {
        String regexNumber = "^[1-9]*$";
        if(!Pattern.matches(regexNumber, answer)){
            throw new IllegalArgumentException("1 ~ 9 까지의 숫자가 아닙니다.");
        }
    }

    public static void isOutOfBounds(String answer) {
        if(answer.length() != 3){
            throw new IllegalArgumentException("3자리 숫자만 가능합니다.");
        }
    }

    public static void isNotDistinct(String answer) {
        if(!isDuplication(answer)){
            throw new IllegalArgumentException("각 자리 수는 중복이 될 수 없습니다.");
        }
    }

    public static boolean isDuplication(String input) {
        List<String> duplicationCheckList = Arrays.asList(input.split(""));
        return duplicationCheckList.size() == duplicationCheckList.stream().distinct().count();
    }
}
