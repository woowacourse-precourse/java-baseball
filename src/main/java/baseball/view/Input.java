package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public List<Integer> inputUserBalls() {
        System.out.println("숫자를 입력해주세요 : ");
        return Arrays.stream(Console.readLine().split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

}
