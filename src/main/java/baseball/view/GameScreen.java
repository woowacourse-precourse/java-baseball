package baseball.view;

import baseball.model.GameResult;

public class GameScreen {
    static final String GAME_START = "숫자 야구 게임을 시작합니다.";
    static final String PLAYER_INPUT = "숫자를 입력해주세요 : ";

    private static final String BALL = "볼 ";
    private static final String STRIKE = "스트라이크 ";
    private static final String NOTHING = "낫싱 ";

    public static void printGameStart() {
        System.out.println(GAME_START);
    }

    public static void printUserInput() {
        System.out.print(PLAYER_INPUT);
    }

    public static void printGameResult(GameResult gameResult) {
        StringBuilder print = new StringBuilder();
        int ball = gameResult.getBall();
        int strike = gameResult.getStrike();

        if (ball > 0) {
            print.append(ball).append(BALL);
        }
        if (strike > 0) {
            print.append(strike).append(STRIKE);
        }
        if (ball + strike == 0) {
            print.append(NOTHING);
        }
        print.deleteCharAt(print.length() - 1);

        System.out.println(print);
    }
}
