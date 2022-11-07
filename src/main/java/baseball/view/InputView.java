package baseball.view;

import camp.nextstep.edu.missionutils.Console;
import java.text.MessageFormat;

public class InputView {

    private InputView() {
    }

    public static String scanPlayerBalls() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String scanCommand() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println(
                MessageFormat.format("게임을 새로 시작하려면 {0}, 종료하려면 {1}를 입력하세요.",
                        Command.REPLAY.getValue(),
                        Command.QUIT.getValue())
        );
        return Console.readLine();
    }
}
