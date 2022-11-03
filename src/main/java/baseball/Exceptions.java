package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Exceptions {

    public static void isValidateInput(String inputValueOfUserNums) {
        isValidateLength(inputValueOfUserNums);
        isNumeral(inputValueOfUserNums);
        isUniqueNumbers(inputValueOfUserNums);
    }

    private static void isValidateLength(String inputValueOfUserNums) {
        int validateLength = 3;
        if (inputValueOfUserNums.length() != validateLength) {
            throw new IllegalArgumentException("입력하신 값의 길이가 3이 아닙니다.");
        }
    }

    private static void isNumeral(String inputValueOfUserNums) {
        try {
            Integer.parseInt(inputValueOfUserNums);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력하신 값이 숫자가 아닙니다. 프로그램을 종료합니다.");
        }
    }

    private static void isUniqueNumbers(String inputValueOfUserNums) {
        List<Integer> userNums = UserNumber.convertInputStringToUserNums(inputValueOfUserNums);
        List<Integer> uniqueNumbers = userNums.stream()
                .distinct()
                .collect(Collectors.toList());

        if (uniqueNumbers.size() != 3) {
            throw new IllegalArgumentException("중복된 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }

    }
}
