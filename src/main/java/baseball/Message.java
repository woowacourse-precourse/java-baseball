package baseball;

import static baseball.ConstValue.*;

public class Message {
    public static final String BALL_AND_STRIKE = "%d볼 %d스트라이크\n";
    public static final String CHOOSE_TO_START_OR_QUIT_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String NOT_THING = "낫싱";
    public static final String ONLY_BALL = "%d볼\n";
    public static final String ONLY_STRIKE = "%d스트라이크\n";
    public static final String PLEASE_ENTER_NUMBERS = "숫자를 입력해주세요 : ";

    public static void gameStart() {
        System.out.println(GAME_START_MESSAGE);
    }

    public static void gameEnd() {
        System.out.println(GAME_END_MESSAGE);
    }

    public static void enterNumber() {
        System.out.print(PLEASE_ENTER_NUMBERS);
    }

    public static void chooseRestartOrQuitGame() {
        System.out.println(CHOOSE_TO_START_OR_QUIT_GAME);
    }

    public static void onlyBallCount() {
        System.out.printf(ONLY_BALL, Score.getValue(BALL));
    }

    public static void onlyStrikeCount() {
        System.out.printf(ONLY_STRIKE, Score.getValue(STRIKE));
    }

    public static void ballAndStrikeCount() {
        System.out.printf(BALL_AND_STRIKE, Score.getValue(BALL), Score.getValue(STRIKE));
    }

    public static void notThing() {
        System.out.println(NOT_THING);
    }
}
