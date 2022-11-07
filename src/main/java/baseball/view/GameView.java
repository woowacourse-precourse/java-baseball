package baseball.view;

import static baseball.domain.CountStatus.NOTHING;
import static baseball.domain.CountStatus.ONLY_BALL;
import static baseball.domain.CountStatus.ONLY_STRIKE;

import baseball.domain.CountStatus;
import baseball.domain.Score;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class GameView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다. ";
    private static final String ASK_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String FINISH_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String ASK_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String ONLY_STRIKE_MESSAGE = "%d스트라이크\n";
    private static final String ONLY_BALL_MESSAGE = "%d볼\n";
    private static final String BALL_AND_STRIKE_MESSAGE = "%d볼 %d스트라이크\n";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printStartMessage() {
        System.out.print(START_MESSAGE);
    }

    public static String askUserInput() {
        System.out.print(ASK_USER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static void printHint(Score score) {
        CountStatus countStatus = score.getCountStatus();
        List<Integer> strikeAndBallCount = score.getStrikeAndBallCount(countStatus);

        if (countStatus == NOTHING) {
            System.out.println(NOTHING_MESSAGE);
            return;
        }
        if (countStatus == ONLY_STRIKE) {
            System.out.printf(ONLY_STRIKE_MESSAGE, strikeAndBallCount.get(0));
            return;
        }
        if (countStatus == ONLY_BALL) {
            System.out.printf(ONLY_BALL_MESSAGE, strikeAndBallCount.get(0));
            return;
        }
        System.out.printf(BALL_AND_STRIKE_MESSAGE, strikeAndBallCount.get(0), strikeAndBallCount.get(1));
    }

    public static String askRestart() {
        System.out.println(ASK_RESTART_MESSAGE);
        return Console.readLine();
    }

    public static void printResult() {
        System.out.println(FINISH_MESSAGE);
    }
}
