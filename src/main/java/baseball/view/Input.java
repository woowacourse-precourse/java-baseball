package baseball.view;

import baseball.domain.Button;
import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    private static final String REQUEST_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART_EXCEPTION_MESSAGE = "1 or 2 만 입력이 가능합니다.";

    public List<Integer> inputUserBalls() {
        System.out.print(REQUEST_NUMBERS_MESSAGE);
        return Arrays.stream(getSplit())
                .map(Integer::parseInt)
                .collect(Collectors.toUnmodifiableList());
    }

    public boolean inputReGameButton() {
        System.out.println(RESTART_GAME_MESSAGE);
        String answer = Console.readLine();
        if (answer.equals(Button.Yes.getButtonValue())) {
            return true;
        } else if (answer.equals(Button.No.getButtonValue())) {
            return false;
        }
        throw new IllegalArgumentException(RESTART_EXCEPTION_MESSAGE);
    }

    private static String[] getSplit() {
        return Console.readLine().split("");
    }

}
