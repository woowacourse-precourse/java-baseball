package baseball;

import baseball.exception.NumberExceptionUtils;
import camp.nextstep.edu.missionutils.Console;



import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class GameUtils {

    public static List<Integer> getPlayerInputNum() {
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        checkValidInput(input);
        return mapStringToIntegerList(input);
    }

    private static List<Integer> mapStringToIntegerList(String input) {
        return Stream.of(input.split(""))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    private static void checkValidInput(String input) {
        NumberExceptionUtils.isPositiveDigits(input);
        NumberExceptionUtils.isThreeDigits(input);
        NumberExceptionUtils.isNotDuplicateNumber(input);
    }
}
