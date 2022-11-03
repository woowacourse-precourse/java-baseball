package baseball.view;

import baseball.domain.Ball;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public List<Integer> inputUserBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        return Arrays.stream(getSplit())
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    private static String[] getSplit() {
        return Console.readLine().split("");
    }

}
