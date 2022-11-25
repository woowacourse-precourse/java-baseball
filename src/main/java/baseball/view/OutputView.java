package baseball.view;

import baseball.domain.dto.Score;
import baseball.system.SystemConstant;

public final class OutputView {
    private final String BALL = "볼";
    private final String STRIKE = "스트라이크";
    private final String NOTHING = "낫싱";
    private final String GAME_END_AND_RESTART_MESSAGE =
            SystemConstant.GAME_DIGIT + "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 " + SystemConstant.GAME_RESTART_CODE +
            ", 종료하려면 " + SystemConstant.GAME_EXIT_CODE + "를 입력하세요.\n";

    public void printFinalResult(Score userScore) {
        printProgress(userScore);
        System.out.println(GAME_END_AND_RESTART_MESSAGE);
    }

    public void printProgress(Score userScore) {
        printMessage(userScore);
    }
    

    private void printMessage(Score score) {
        if (score.getBall() == 0 && score.getStrike() == 0) {
            System.out.println(NOTHING);
            return;
        }
        System.out.println(
                makeBallMessageIfExists(score.getBall())
                        + " "
                        + makeStrikeMessageIfExists(score.getStrike())
        );
    }

    private String makeBallMessageIfExists(int ballCount) {
        if (ballCount == 0) {
            return "";
        }
        return ballCount + BALL;
    }

    private String makeStrikeMessageIfExists(int strikeCount) {
        if (strikeCount == 0) {
            return "";
        }
        return strikeCount + STRIKE;
    }
}
