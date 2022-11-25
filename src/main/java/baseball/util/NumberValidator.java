package baseball.util;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class NumberValidator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    public static void validateDuplicates(List<Integer> computerNumber) {
        if (hasDuplicates(computerNumber)) {
            throw new IllegalArgumentException("컴퓨터의 수에 중복된 숫자가 존재합니다.");
        }
    }

    private static boolean hasDuplicates(List<Integer> computerNumber) {
        return sizeOfDuplicatesRemoved(computerNumber) != computerNumber.size();
    }

    private static int sizeOfDuplicatesRemoved(List<Integer> computerNumber) {
        return computerNumber.stream().collect(Collectors.toSet()).size();
    }

    public static void validateNumberType(String input){
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    public static void validateNumberLength(String input){
        if(input.length() != 3){
            throw new IllegalArgumentException("세 자리 숫자만 입력할 수 있습니다.");
        }
    }
}
