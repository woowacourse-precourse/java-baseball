package baseball.view;

import java.io.IOException;

public class PlayingGameView extends Game{
    public void enterNumberPrint() {
        StringBuilder sb = new StringBuilder();
        sb.append("숫자를 입력해주세요 : ");
        print(sb.toString());
    }
    public void gameResultPrint(int strike, int ball) {
        StringBuilder sb = new StringBuilder();
        if (ball > 0) {
            sb.append(ball + "볼 ");
        }
        if (strike > 0) {
            sb.append(strike + "스트라이크 ");
        }
        if (strike == 0 && ball == 0) {
            sb.append("낫싱");
        }
        sb.append("\n");
        print(sb.toString());
    }
}
