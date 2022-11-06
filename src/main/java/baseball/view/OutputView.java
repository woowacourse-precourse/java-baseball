package baseball.view;

public class OutputView {

    public static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String THREESTRIKE = "3스트라이크";
    public static final String NOTHING = "낫싱";

    public static void gameEnd() {
        System.out.println(GAME_END);
    }

    public static void threeStrike() {
        System.out.println(THREESTRIKE);
    }

    public static void nothing() {
        System.out.println(NOTHING);
    }
}
