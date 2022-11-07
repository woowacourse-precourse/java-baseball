package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private static final char ZERO = '0';
    private static final char NINE = '9';

    public static BaseballGameNumber readNumber() {
        String line = removeBlank(Console.readLine());
        return new BaseballGameNumber(toInts(line));
    }

    public static GameStatus readGameStatus() {
        String line = removeBlank(Console.readLine());
        return GameStatus.findGameStatus(line);
    }

    private static String removeBlank(String line) {
        return line.replace(" ", "");
    }

    private static List<Integer> toInts(String line) {
        List<Integer> list = new ArrayList<>();
        for (int index = 0; index < line.length(); index++) {
            char digit = line.charAt(index);
            validateNumber(digit);
            list.add(toInt(digit));
        }
        return list;
    }

    private static void validateNumber(char digit) {
        if (digit < ZERO || digit > NINE) {
            throw new IllegalArgumentException("숫자가 아닌 문자가 포함되었습니다.");
        }
    }

    private static int toInt(char digit) {
        return digit - ZERO;
    }
}
