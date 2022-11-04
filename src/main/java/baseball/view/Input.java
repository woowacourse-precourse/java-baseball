package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static final String REQUEST_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    public List<Integer> inputUserBalls() {
        System.out.print(REQUEST_NUMBERS_MESSAGE);
        return Arrays.stream(getSplit())
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    private static String[] getSplit() {
        return Console.readLine().split("");
    }

}
