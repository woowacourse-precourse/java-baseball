package baseball.view;

import baseball.dto.StrikeBallCountDto;

public class ConsoleView {

    private final static String WELCOME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final static String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private final static String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private final static String STRIKE = "스트라이크";
    private final static String BALL = "볼";
    private final static String NOTHING = "낫싱";

    public void printWelcomeMessage() {
        System.out.println(WELCOME_MESSAGE);
    }
    public void printInputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }

    public void printRestartMessage() {
        System.out.println(RESTART_MESSAGE);
    }

    public void printStrikeBallCount(StrikeBallCountDto strikeBallCountDto) {
        int strikeCount = strikeBallCountDto.getStrikeCount();
        int ballCount = strikeBallCountDto.getBallCount();

        if (strikeCount == 0 && ballCount == 0) {
            System.out.println(NOTHING);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder();

        if (ballCount > 0) {
            stringBuilder.append(ballCount).append(BALL);
        }

        if (ballCount > 0 && strikeCount > 0) {
            stringBuilder.append(" ");
        }

        if (strikeCount > 0) {
            stringBuilder.append(strikeCount).append(STRIKE);
        }

        System.out.println(stringBuilder);
    }
}
