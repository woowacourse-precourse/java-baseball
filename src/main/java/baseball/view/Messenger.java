package baseball.view;

import java.util.ArrayList;
import java.util.List;

public class Messenger {

    public void printStartMessage() {
        System.out.print("게임을 시작합니다.\n");
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력하세요. : ");
    }

    public void printAnswerMessage() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    public void printRestartOrEndMessage() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }

    public void printResultMessage(int strike, int ball) {
        List<String> decisions = new ArrayList<>();
        String countMessage;
        if (!isZero(ball)) {
            countMessage = String.format("%d볼", ball);
            decisions.add(countMessage);
        }
        if (!isZero(strike)) {
            countMessage = String.format("%d스트라이크", strike);
            decisions.add(countMessage);
        }
        if (isZero(ball) && isZero(strike)) {
            countMessage = "낫싱";
            decisions.add(countMessage);
        }
        System.out.print(String.join(" ", decisions) + "\n");
    }

    private boolean isZero(int number) {
        return number == 0;
    }
}
