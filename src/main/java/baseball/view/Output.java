package baseball.view;

import baseball.model.Result;

public final class Output {
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String GAME_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private Output() {
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printResult(Result result) {
        StringBuilder resultBuilder = new StringBuilder();
        if (result.hasNothing()) {
            resultBuilder.append(NOTHING_MESSAGE);
        }
        if (result.hasBall()) {
            resultBuilder.append(result.getBallCount())
                         .append(BALL_MESSAGE);
        }
        if (result.hasStrike()) {
            resultBuilder.append(result.getStrikeCount())
                         .append(STRIKE_MESSAGE);
        }
        if (result.isGameOver()) {
            resultBuilder.append("\n" + GAME_OVER_MESSAGE)
                         .append("\n" + GAME_RESTART_MESSAGE);
        }
        System.out.println(resultBuilder);
    }
}
