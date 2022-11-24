package baseball.view;

import baseball.domain.dto.Score;
import baseball.system.SystemConstant;

import java.util.List;

public final class OutputView {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String GAME_END_AND_RESTART_MESSAGE =
            SystemConstant.GAME_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 " + SystemConstant.GAME_RESTART_CODE +
            ", 종료하려면 " + SystemConstant.GAME_EXIT_CODE + "를 입력하세요.\n";


    public void printProgress(Score data) {
        printMessage(data);
    }

    public void printFinalResult(Score data) {
        printMessage(data);
    }

    public static void printMessage(Score score) {
        if (score.get(0) == 0 && score.get(1) == 0) {
            System.out.println(NOTHING.message);
            return;
        }
        System.out.println(
                makeBallMessageIfExists(score.get(0))
                        + SPACE.message
                        + makeStrikeMessageIfExists(score.get(1))
        );
    }

    private static String makeBallMessageIfExists(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + BALL.message;
    }

    private static String makeStrikeMessageIfExists(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + STRIKE.message;
    }
}
