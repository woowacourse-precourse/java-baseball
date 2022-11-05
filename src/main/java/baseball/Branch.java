package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Branch {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    public static final String INPUT_RE_START = "1";
    public static final String INPUT_END = "2";
    public static final int AGAIN_SIGNAL = -1;
    public static final int RE_START_SIGNAL = -2;
    public static final int GAME_EXIT_SIGNAL = -3;

    public int gameCount(int ballCount, int strikeCount) {
        if (strikeCount == 3) {
            System.out.println(strikeCount + STRIKE);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

            String branch = Console.readLine();

            return gameBranch(branch);

        } else if (ballCount > 0 && strikeCount == 0) {
            System.out.println(ballCount + BALL);
            return AGAIN_SIGNAL;

        } else if (ballCount == 0 && strikeCount > 0) {
            System.out.println(strikeCount + STRIKE);
            return AGAIN_SIGNAL;

        } else if (ballCount == 0 && strikeCount == 0) {
            System.out.println(NOTHING);
            return AGAIN_SIGNAL;

        } else {
            System.out.println(ballCount + BALL + " " + strikeCount + STRIKE);
            return AGAIN_SIGNAL;
        }
    }

    public int gameBranch(String input) {
        if (input.equals(INPUT_RE_START)) {
            return RE_START_SIGNAL;

        } else if (input.equals(INPUT_END)) {
            return GAME_EXIT_SIGNAL;

        } else {
            throw new IllegalArgumentException();
        }
    }

}