package baseball.game;

import baseball.game.number.Number;
import java.util.List;

public class GamePrinter {
    private final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String INPUT_PROMPT = "숫자를 입력해주세요 : ";
    private final String PAUSE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final int BALL_IDX = 0;
    private final int STRIKE_IDX = 1;
    private final String BALL_STRING = "볼";
    private final String STRIKE_STRING = "스트라이크";
    private final String NOTHING_STRING = "낫싱";
    private final String BLANK = " ";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printInputPrompt() {
        System.out.println(INPUT_PROMPT);
    }

    public void printPauseMessage() {
        System.out.println(PAUSE_MESSAGE);
    }

    public void printEndMessage() {
        System.out.println(END_MESSAGE);
    }

    public void printResult(List<Integer> result) {
        int ballCount = result.get(BALL_IDX);
        int strikeCount = result.get(STRIKE_IDX);
        StringBuilder resultStr = new StringBuilder();
        if (ballCount != 0 && strikeCount != Number.FULL_SIZE) {
            resultStr.append(ballCount);
            resultStr.append(BALL_STRING);
            resultStr.append(BLANK);
        }
        if (strikeCount != 0) {
            resultStr.append(strikeCount);
            resultStr.append(STRIKE_STRING);
        }
        if (ballCount == 0 && strikeCount == 0) {
            resultStr.append(NOTHING_STRING);
        }
        System.out.println(resultStr);
    }
}
