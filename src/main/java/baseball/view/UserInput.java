package baseball.view;

import static java.lang.System.out;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {

    public static List<Integer> InputUserNumbers() {
        out.println("숫자를 입력해주세요 : ");
        String userNumbersInput = Console.readLine();
        return toIntegerList(userNumbersInput);
    }

    private static List<Integer> toIntegerList(String userNumbersInput) {
        String[] userNumbers = userNumbersInput.split("");
        return Arrays.stream(userNumbers)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }

    public static String SelectRestartOrExit() {
        out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }

}
