package baseball.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NumberValidator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[1-9]*$");

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


    public static void validateType(String input) {
        if (!NUMBER_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException("1부터 9까지 이루어진 숫자만 입력 가능합니다.");
        }
    }

    public static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세 자리 숫자만 입력 가능합니다.");
        }
    }


}
