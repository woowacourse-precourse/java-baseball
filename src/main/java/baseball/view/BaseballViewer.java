package baseball.view;

import baseball.model.CountStatus;
import baseball.model.Score;

import static baseball.model.CountStatus.*;
import static baseball.model.CountStatus.ONLY_STRIKE;

public class BaseballViewer {

    public void showStartText() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void showInputText() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void showWinText() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void showRestartGameText() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void showScore(Score score) {
        CountStatus countStatus = score.status();

        if (countStatus == NO_COUNT) {
            System.out.println("낫싱");
        }
        if (countStatus == ONLY_BALL) {
            System.out.println(score.getBall() + "볼");
        }
        if (countStatus == BALL_AND_STRIKE) {
            System.out.println(score.getBall() + "볼 " + score.getStrike() + "스트라이크");
        }
        if (countStatus == ONLY_STRIKE) {
            System.out.println(score.getStrike() + "스트라이크");
        }
    }
}
