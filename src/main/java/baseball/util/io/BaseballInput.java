package baseball.util.io;

import baseball.validation.Validator;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BaseballInput {

    public static List<Integer> gamePlay(final Validator<List<Integer>> validator) {
        System.out.print("숫자를 입력해주세요 : ");
        List<Integer> inputNumbers = inputNumbers();
        if (!validator.validate(inputNumbers)) {
            throw new IllegalArgumentException();
        }
        return inputNumbers;
    }

    public static boolean gameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            return true;
        } else if (input.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> inputNumbers() {
        return Arrays.stream(Console.readLine().split("")).map(Integer::valueOf)
            .collect(Collectors.toList());
    }
}
