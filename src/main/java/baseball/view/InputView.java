package baseball.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static final String CRITERION_SPLIT = "";

    public static List<Integer> inputNumbers() {
        String numberString = Console.readLine();
        String[] splitNumberString = numberString.split(CRITERION_SPLIT);
        return mapToInteger(splitNumberString);
    }

    private static List<Integer> mapToInteger(String[] split) {
        return Arrays.stream(split)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputRestart() {
        return Integer.parseInt(Console.readLine());
    }

}
