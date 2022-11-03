package baseball.view;

import baseball.domain.PlayResult;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NOTHING = "낫싱";

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printResult(PlayResult playResult) {
        StringBuilder sb = new StringBuilder();
        if (playResult.isNothing()) {
            sb.append(NOTHING);
        }
        if (playResult.getBall() != 0) {
            sb.append(playResult.getBall() + "볼 ");
        }
        if (playResult.getStrike() != 0) {
            sb.append(playResult.getStrike() + "스트라이크 ");
        }
        System.out.println(sb);
    }

    public static void printEndMessage() {
        System.out.println(GAME_END_MESSAGE);
    }
}
