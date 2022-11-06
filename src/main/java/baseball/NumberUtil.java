package baseball;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberUtil {
    public static final int NUMBER_SIZE = 3;
    public static final int NUMBER_START = 1;
    public static final int NUMBER_END = 9;
    public static final int COMMAND_SIZE = 1;
    public static final int COMMAND_START = 1;
    public static final int COMMAND_END = 2;

    public static List<Integer> random() {
        List<Integer> randomNumberList = new ArrayList<>();
        while (randomNumberList.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(NUMBER_START, NUMBER_END);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public static List<Integer> inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        return parse(Console.readLine());
    }

    public static int inputNumber() {
        String str = Console.readLine();
        if (lengthCheck(str, COMMAND_SIZE) && numericBoundCheck(str, COMMAND_START, COMMAND_END)) {
            return Integer.parseInt(str);
        }
        return 0;
    }

    public static List<Integer> parse(String str) {
        if (lengthCheck(str, NUMBER_SIZE) && numericBoundCheck(str, NUMBER_START, NUMBER_END) && noDuplicateCheck(str)) {
            return str.chars()
                    .mapToObj(ch -> (char) ch)
                    .map(Character::getNumericValue)
                    .collect(Collectors.toList());
        }
        return null;
    }

    public static boolean lengthCheck(String str, int length) {
        if (str == null) {
            return length == 0;
        }
        return str.length() == length;
    }

    public static boolean numericBoundCheck(String str, int start, int end) {
        if (str == null) {
            return false;
        }
        return str.chars()
                .mapToObj(ch -> (char) ch)
                .filter(Character::isDigit)
                .mapToInt(Character::getNumericValue)
                .filter(i -> start <= i && i <= end)
                .count() == str.length();
    }

    public static boolean noDuplicateCheck(String str) {
        if (str == null) {
            return true;
        }
        return str.chars().distinct().count() == str.length();
    }
}
