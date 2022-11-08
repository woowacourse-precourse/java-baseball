package baseball.utils;

import static baseball.BaseballGame.INPUT_SIZE;

import baseball.domain.Score;

public class OutputGenerator {
    public void printWelcome() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printRequestBallNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameEnd() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", INPUT_SIZE);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printScore(Score score) {
        System.out.println(score);
    }
}
