package baseball.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputController {

    private static String getLine() {
        return Console.readLine();
    }

    private static Integer getNumberLine(Integer length) {
        String line = getLine();

        if (line.length() != length) {
            throw new IllegalArgumentException();
        }

        return parseInt(line);
    }

    public static List<Integer> getEachNumber(Integer length) {
        return convertToEachNumberList(getNumberLine(length));
    }

    public static Integer getOneNumber() {
        return getNumberLine(1);
    }

    private static List<Integer> convertToEachNumberList(Integer number) {
        return Arrays.stream(number.toString().split("")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private static Integer parseInt(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
