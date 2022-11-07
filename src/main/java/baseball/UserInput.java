package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Constants.*;
import static baseball.Functions.stringToIntegerList;
public class UserInput {
    public static String numberInput() {
        System.out.print(INPUT_NUMBER);
        String input = Console.readLine();
        input = input.trim();
        if (!isValidInput(input))
            throw new IllegalArgumentException(INPUT_EXCEPTION);
        return input;
    }

    public static String continueInput() {
        String input = Console.readLine();
        input = input.trim();
        if (!isValidContInput(input))
            throw new IllegalArgumentException(INPUT_EXCEPTION);
        return input;
    }

    private static boolean isValidInput(String input) {
        if (!isString_in_1to9(input)) return false;
        //정규 표현식을 이용해 Input이 숫자가 아닌 모든 경우와 Input의 범위가 1~9사이가 아닌 경우를 동시에 처리

        if (!isValidSize(input)) return false;
        if (!isNotDuplicate(input)) return false;
        return true;
    }

    private static boolean isString_in_1to9(String str) {
        return str.matches("[1-9.]+");
    }

    private static boolean isValidSize(String str) {
        return str.length() == Max_size;
    }

    private static boolean isNotDuplicate(String str) {
        List<Integer> numList = stringToIntegerList(str);
        Set<Integer> numSet = new HashSet<>(numList);
        return numSet.size() == numList.size();
    }

    private static boolean isValidContInput(String str) {
        if (str.equals(CONTINUE) || str.equals(END)) {
            return true;
        }
        return false;
    }
}
