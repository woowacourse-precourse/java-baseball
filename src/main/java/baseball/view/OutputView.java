package baseball.view;

import baseball.Result;

public class OutputView {
    private static final int THREE = 3;
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼 ";
    private static final String NOTHING = "낫싱";
    private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void requestInputNumber() {
        System.out.println(INPUT_NUMBER);
    }

    public static void gameResult(Result result) {
        if (result.getBall() != 0 && result.getStrike() == 0) {
            System.out.println(result.getBall() + BALL);
        }
        if(result.getStrike()==3){
            System.out.println(THREE+STRIKE);
        }
        if (result.getBall() == 0 && result.getStrike() != 0) {
            System.out.println(result.getStrike() + STRIKE);
        }
        if (result.getBall() == 0 && result.getStrike() == 0) {
            System.out.println(NOTHING);
        }
        if (result.getBall() != 0 && result.getStrike() != 0) {
            System.out.println(result.getBall() + BALL + result.getStrike() + STRIKE);
        }

    }
}
