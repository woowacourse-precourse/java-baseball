package baseball.game;

import static baseball.util.ComputerUtil.getComputerNumbers;
import static baseball.util.UserUtil.checkRestartOrExit;
import static baseball.util.UserUtil.getUserNumbers;

import java.util.List;

public class Baseball {

    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String NOTHING_MESSAGE = "낫싱";

    private static final String GAME_STARTED_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_FINISHED_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private int strikeCount;
    private int ballCount;

    public void proceedGame() {
        while (true) {
            startGame();

            if (stopGame()) {
                break;
            }
        }
    }

    private void startGame() {
        List<Integer> computerNumbers = getComputerNumbers();

        System.out.println(GAME_STARTED_MESSAGE);

        while (true) {
            initializeCounts();

            System.out.print(INPUT_NUMBER_MESSAGE);

            List<Integer> userNumbers = getUserNumbers();

            countStrikeAndBall(computerNumbers, userNumbers);

            printHint();

            if (isAnswer()) {
                System.out.println(GAME_FINISHED_MESSAGE);
                break;
            }
        }
    }

    private void initializeCounts() {
        strikeCount = 0;
        ballCount = 0;
    }

    private void countStrikeAndBall(List<Integer> computerNumbers, List<Integer> userNumbers) {
        for (int i = 0; i < 3; i++) {
            String result = getStrikeOrBall(computerNumbers, userNumbers.get(i), i);

            if (result.equals(STRIKE_MESSAGE)) {
                strikeCount++;
            }

            if (result.equals(BALL_MESSAGE)) {
                ballCount++;
            }
        }
    }

    private String getStrikeOrBall(List<Integer> computerNumbers, int userNumber, int index) {
        for (int i = 0; i < 3; i++) {
            if (hasSameNumberAndIndex(computerNumbers, userNumber, i, index)) {
                return STRIKE_MESSAGE;
            }

            if (hasSameNumber(computerNumbers, userNumber, i)) {
                return BALL_MESSAGE;
            }
        }

        return NOTHING_MESSAGE;
    }

    private boolean hasSameNumberAndIndex(List<Integer> computerNumbers, int userNumber, int i, int index) {
        return hasSameNumber(computerNumbers, userNumber, i) && hasSameIndex(i, index);
    }

    private boolean hasSameNumber(List<Integer> computerNumbers, int userNumber, int i) {
        return computerNumbers.get(i) == userNumber;
    }

    private boolean hasSameIndex(int i, int index) {
        return i == index;
    }

    private void printHint() {
        String hint = getHint(ballCount, strikeCount);
        System.out.println(hint);
    }

    private String getHint(int ballCount, int strikeCount) {
        String hint = "";

        if (hasNothing(ballCount, strikeCount)) {
            hint = NOTHING_MESSAGE;
        }

        if (hasBallCount(ballCount)) {
            hint = ballCount + BALL_MESSAGE;
        }

        if (hasStrikeCount(strikeCount)) {
            hint = hint + strikeCount + STRIKE_MESSAGE;
        }

        return hint;
    }

    private boolean hasNothing(int ballCount, int strikeCount) {
        return strikeCount == 0 && ballCount == 0;
    }

    private boolean hasBallCount(int ballCount) {
        return ballCount > 0;
    }

    private boolean hasStrikeCount(int strikeCount) {
        return strikeCount > 0;
    }

    private boolean isAnswer() {
        return strikeCount == 3;
    }

    private boolean stopGame() {
        System.out.println(RESTART_OR_EXIT_MESSAGE);

        if (!checkRestartOrExit()) {
            return true;
        }
        return false;
    }
}
