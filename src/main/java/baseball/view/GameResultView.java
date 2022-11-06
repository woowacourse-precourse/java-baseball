package baseball.view;

public class GameResultView {
    private static final String THREE_STRIKE_PRINT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String AFTER_GAME_PRINT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 1;

    public void printThreeStrikeResult() {
        System.out.println("3스트라이크");
        System.out.println(THREE_STRIKE_PRINT);
        System.out.println(AFTER_GAME_PRINT);
    }
}
