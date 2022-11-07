package baseball.domain.baseball;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGameResult {

    public final static String NOTHING = "낫싱";
    public final static String BALL = "볼";
    public final static String STRIKE = "스트라이크";
    public final static String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public final static String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private final List<String> answer;

    public BaseBallGameResult() {
        answer = new ArrayList<>();
    }

    public void printNothing() {
        System.out.println(NOTHING);
    }

    public void printGameResult(long ballCount, long strikeCount) {
        addBallResult(ballCount);
        addStrikeResult(strikeCount);
        System.out.println(addBlank());
    }

    public void printGameEnd() {
        printGameResult(0, 3);
        System.out.println(END_MESSAGE);
        System.out.println(RESTART_MESSAGE);
    }

    private void addBallResult(long count) {
        if (count != 0) {
            answer.add(count + BALL);
        }
    }

    private void addStrikeResult(long count) {
        if (count != 0) {
            answer.add(count + STRIKE);
        }
    }

    private String addBlank() {
        return String.join(" ", answer);
    }
}
