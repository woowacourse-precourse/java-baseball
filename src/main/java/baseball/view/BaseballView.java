package baseball.view;

import baseball.model.Score;

import static baseball.view.CountStatus.*;

public class BaseballView {

    public void showStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void showInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public String showScore(Score score) {
        int strike = score.getStrike();
        int ball = score.getBall();

        if (NO_COUNT.check(score)) {
            System.out.println("낫싱");
        }
        if (ONLY_BALL.check(score)) {
            System.out.println(ball + "볼");
        }
        if (BALL_AND_STRIKE.check(score)) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (ONLY_STRIKE.check(score)) {
            System.out.println(strike + "스트라이크");
        }
        return strike + "스트라이크";
    }

    public void showContinueOrStop() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
