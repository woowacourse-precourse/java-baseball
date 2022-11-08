package baseball.view;

import java.util.List;

import baseball.system.SystemConstant;

public enum OutputMsgContainer {
    BALL("볼"),
    STRIKE("스트라이크"),
    SPACE(" "),
    NOTHING("낫싱"),
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다.\n"),
    GAME_END_AND_RESTART_MESSAGE(
            SystemConstant.GAME_DIGIT +
                    "개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                    "게임을 새로 시작하려면 " + SystemConstant.GAME_RESTART_CODE +
                    ", 종료하려면 " + SystemConstant.GAME_EXIT_CODE + "를 입력하세요.\n"
    ),
    GAME_INPUT_MESSAGE("숫자를 입력해주세요 : ");

    private final String message;

    OutputMsgContainer(String message) {
        this.message = message;
    }

    public static void printMessage(OutputMsgContainer data) {
        System.out.print(data.message);
    }

    public static void printMessage(List<Integer> score) {
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
