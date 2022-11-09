package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputReader {

    public static boolean readGameStatus() throws IllegalArgumentException {
        String inputString = Console.readLine();
        if (!inputString.equals("1") && !inputString.equals("2")) {
            throw new IllegalArgumentException("1 또는 2를 입력해야합니다.");
        }
        return inputString.equals("1");
    }

    public static List<String> readNumber() throws IllegalArgumentException {
        String inputString = Console.readLine();
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력해야 합니다.");
        }

        if (inputString.length() != BaseballNumber.numberLength) {
            throw new IllegalArgumentException("숫자의 길이는 " + BaseballNumber.numberLength + "이여야 합니다.");
        }
        List<String> inputNumber = new ArrayList<String>(Arrays.asList(inputString.split("")));

        if (new HashSet<String>(inputNumber).size() != BaseballNumber.numberLength) {
            throw new IllegalArgumentException("서로 다른 " + BaseballNumber.numberLength + "자리 숫자를 입력해야 합니다.");
        }

        return inputNumber;
    }
}
