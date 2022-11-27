package baseball.view;

import baseball.system.SystemConstant;
import baseball.verifier.BaseballNumVerifier;
import baseball.verifier.ControlNumberVerifier;
import baseball.verifier.Verifier;
import camp.nextstep.edu.missionutils.Console;

public final class InputView {
    private final String GAME_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final String GAME_END_AND_RESTART_MESSAGE =
            SystemConstant.GAME_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 " + SystemConstant.GAME_RESTART_CODE +
                    ", 종료하려면 " + SystemConstant.GAME_EXIT_CODE + "를 입력하세요.\n";

    public int readGameInput() {
        System.out.print(GAME_INPUT_MESSAGE);
        String line = Console.readLine();

        Verifier baseballNumVerifier = new BaseballNumVerifier();
        baseballNumVerifier.check(line);
        return Integer.parseInt(line);
    }

    public int readGameControlInput() {
        System.out.println(GAME_END_AND_RESTART_MESSAGE);
        String line = Console.readLine();

        Verifier controlVerifier = new ControlNumberVerifier();
        controlVerifier.check(line);
        return Integer.parseInt(line);
    }
}
