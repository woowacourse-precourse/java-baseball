package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.Functions.stringToIntegerList;
import static baseball.Game.Max_size;
import static baseball.Game.CONTINUE;
import static baseball.Game.END;

public class UserInput {
    public static String numberInput() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        input = input.trim();
        try {
            if (!isValidInput(input))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            invalid_Input_message();
            System.exit(0);
        }
        return input;
    }

    public static String continueInput() {
        String input = Console.readLine();
        input = input.trim();
        try {
            if (!isValidContInput(input)) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            invalid_Input_message();
            System.exit(0);
        }
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

    private static void invalid_Input_message() {
        System.out.println("잘못된 입력입니다. 프로그램이 종료됩니다.");
    }
}
