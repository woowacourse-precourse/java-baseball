package baseball.view;

import baseball.model.User;

public class OutputView {
    private String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    User user = new User();

    public void printHint() {
        int strike = user.getStrike();
        int ball = user.getBall();

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        else if (strike == 0) {
            System.out.println(String.format("%d볼", ball));
        }
        else if (ball == 0) {
            System.out.println(String.format("%d스트라이크", strike));
        }
        else {
            System.out.println(String.format("%d볼 %d스트라이크",ball, strike));
        }
    }

    public void printGameEnd() {
        System.out.println(GAME_END);
    }

}
